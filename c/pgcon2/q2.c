#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LEN ( 10000 )

char line[MAX_LEN];
char *cols[MAX_LEN];
char card[4][13];
char check[4];

int split(char *str, const char *delim, char *outlist[]) {
    char *token;
    int count = 0;

    token = strtok(str, delim);
    while (token != NULL && count < MAX_LEN) {
        outlist[count++] = token;
        token = strtok(NULL, delim);
    }
    return count;
}

int getType(char ch) {
	switch (ch) {
	case 'S':
		return 0;
	case 'D':
		return 1;
	case 'C':
		return 2;
	case 'H':
		return 3;
	default:
		return -1;
	}
}

int getNum(char ch) {
	switch (ch) {
	case 'A':
		return 0;
	case '0':
		return 9;
	case 'J':
		return 10;
	case 'Q':
		return 11;
	case 'K':
		return 12;
	default:
		return ch - '0' - 1;
	}
}

void printNum(int type) {
	int i, bFirst = 1;
	char table[] = "A234567890JQK";
	
	for (i=0; i<13; i++) {
		if (card[type][i]) {
			if (!bFirst) printf(",");
			printf("%c", table[i]);
			bFirst = 0;
		}
	}
	printf("\n");
}

int main() {
	int count, i, type, num;
	
	fgets(line, sizeof(line), stdin);
	count = split(line, " ", cols);
	for (i=0; i<count; i++) {
		type = getType(cols[i][0]);
		if (type < 0) continue;
		num = getNum(cols[i][1]);
		//printf("%c %c %d %d\n", cols[i][0], cols[i][1], type, num);
		card[type][num] = 1;
		check[type] = 1;
	}
	if (check[0]) {
		printf("S:");
		printNum(0);
	}
	if (check[1]) {
		printf("D:");
		printNum(1);
	}
	if (check[2]) {
		printf("C:");
		printNum(2);
	}
	if (check[3]) {
		printf("H:");
		printNum(3);
	}
	return 0;
}
