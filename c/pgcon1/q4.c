//プログラムコンテスト
//C言語用
//ファイル名 q4.c
//作成者 
#include <stdio.h>
#include <string.h>
#define MAX_LEN ( 10000 )

char line[MAX_LEN];
char *cols[MAX_LEN];
int bitmap[24][24];

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

int main() {
	int count, o, i, j, v;
	
	fgets(line, sizeof(line), stdin);
	count = split(line, " ", cols);
	o = 0;
	for (i=0; i<24; i++) {
		for (j=0; j<3; j++) {
			sscanf( cols[o++], "%02x", &v );
			bitmap[i][j*8] = v & 0x80;
			bitmap[i][j*8+1] = v & 0x40;
			bitmap[i][j*8+2] = v & 0x20;
			bitmap[i][j*8+3] = v & 0x10;
			bitmap[i][j*8+4] = v & 0x08;
			bitmap[i][j*8+5] = v & 0x04;
			bitmap[i][j*8+6] = v & 0x02;
			bitmap[i][j*8+7] = v & 0x01;
		}
	}
	for (i=0; i<24; i++) {
		for (j=0; j<24; j++) {
			if (bitmap[i][j]) {
				printf("X");
			} else {
				printf(".");
			}
		}
		printf("\n");
	}
	printf("\n");
	for (i=0; i<24; i++) {
		for (j=23; j>=0; j--) {
			if (bitmap[j][i]) {
				printf("X");
			} else {
				printf(".");
			}
		}
		printf("\n");
	}
}
