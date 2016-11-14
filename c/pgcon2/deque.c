#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SIZE ( 8 )
int elements[MAX_SIZE];
int head;
int tail;

void addFirst(int e) {
    head = (head - 1) & (MAX_SIZE - 1);
    elements[head] = e;
    if (head == tail) {
        printf("Deque is full");
    }
}

void addLast(int e) {
    elements[tail] = e;
    tail = (tail + 1) & (MAX_SIZE - 1);
    if (head == tail) {
        printf("Deque is full");
    }
}

int getFirst() {
    int h = head;
    int result = elements[h];
    return result;
}

int getLast() {
    int t = (tail - 1) & (MAX_SIZE - 1);
    int result = elements[t];
    return result;
}

int removeFirst() {
    int h = head;
    int result = elements[h];
    if (result == 0) return 0;
    elements[h] = 0;
    head = (h + 1) & (MAX_SIZE - 1);
    return result;
}

int removeLast() {
    int t = (tail - 1) & (MAX_SIZE - 1);
    int result = elements[t];
    if (result == 0) return 0;
    elements[t] = 0;
    tail = t;
    return result;
}

int size() {
    return (tail - head) & (MAX_SIZE - 1);
}

int main() {
    int i;
    for (i=1; i<MAX_SIZE; i++) {
        printf("head=%d, tail=%d, val=%d\n", head, tail, i);
        addLast(i);
        printf("first=%d, last=%d\n", getFirst(), getLast());
    }
    while (size() > 0) {
        printf("first=%d, last=%d\n", getFirst(), getLast());
        int v = removeFirst();
        printf("head=%d, tail=%d, val=%d\n", head, tail, v);
    }
    for (i=1; i<MAX_SIZE; i++) {
        printf("head=%d, tail=%d, val=%d\n", head, tail, i);
        addLast(i);
        printf("first=%d, last=%d\n", getFirst(), getLast());
    }
    while (size() > 0) {
        printf("first=%d, last=%d\n", getFirst(), getLast());
        int v = removeFirst();
        printf("head=%d, tail=%d, val=%d\n", head, tail, v);
    }
    return 0;
}

