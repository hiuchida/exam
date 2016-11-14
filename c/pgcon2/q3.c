#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LEN ( 10000 )
#define _intMax ( 2147483647 )
typedef int boolean;
#define true  ( 1 )
#define false ( 0 )
#define max(a,b) ((a)>(b)?(a):(b))
#define min(a,b) ((a)<(b)?(a):(b))

char line[MAX_LEN];
#define MAX_SIZE ( 64 )
char elements[MAX_SIZE];
int head;
int tail;

void addFirst(char e) {
    head = (head - 1) & (MAX_SIZE - 1);
    elements[head] = e;
    if (head == tail) {
        printf("Deque is full");
    }
}

void addLast(char e) {
    elements[tail] = e;
    tail = (tail + 1) & (MAX_SIZE - 1);
    if (head == tail) {
        printf("Deque is full");
    }
}

char getFirst() {
    int h = head;
    char result = elements[h];
    return result;
}

char getLast() {
    int t = (tail - 1) & (MAX_SIZE - 1);
    char result = elements[t];
    return result;
}

char removeFirst() {
    int h = head;
    char result = elements[h];
    if (result == 0) return 0;
    elements[h] = 0;
    head = (h + 1) & (MAX_SIZE - 1);
    return result;
}

char removeLast() {
    int t = (tail - 1) & (MAX_SIZE - 1);
    char result = elements[t];
    if (result == 0) return 0;
    elements[t] = 0;
    tail = t;
    return result;
}

int size() {
    return (tail - head) & (MAX_SIZE - 1);
}

void left(char ch) {
    if (size() > 0) {
        if (getFirst() == ch) {
            removeFirst();
        } else {
            addFirst(ch);
        }
    } else {
        addFirst(ch);
    }
}

void right(char ch) {
    if (size() > 0) {
        if (getLast() == ch) {
            removeLast();
        } else {
            addLast(ch);
        }
    } else {
        addFirst(ch);
    }
}

int main() {
    int len;
	fgets(line, sizeof(line), stdin);
	len = strlen(line);
	if (line[len-1] == '\n') line[--len] = '\0';
	long max = 1L << (len-1);
	int min = _intMax;
	long i;
	int j;
	for (i=0; i<max; i++) {
	    head = 0;
	    tail = 0;
	    memset(elements, 0, sizeof(char)*MAX_SIZE);
	    for (j=0; j<len; j++) {
	        long mask = 1L << j;
	        if (i & mask) {
	            left(line[j]);
	        } else {
	            right(line[j]);
	        }
	    }
	    min = min(min, size());
	}
	printf("%d\n", min);
    return 0;
}

