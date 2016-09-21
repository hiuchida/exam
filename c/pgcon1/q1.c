//プログラムコンテスト
//C言語用
//ファイル名 q1.c
//作成者 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LEN ( 10000 )

char line1[MAX_LEN];
char line2[MAX_LEN];
char line3[MAX_LEN];
char *cols2[MAX_LEN];
char *cols3[MAX_LEN];
char list2[MAX_LEN];
char list3[MAX_LEN];
char result[MAX_LEN];

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
    int i, count, n, v, first;

    fgets(line1, sizeof(line1), stdin);
    fgets(line2, sizeof(line2), stdin);
    fgets(line3, sizeof(line3), stdin);
    n = atoi(line1);
    count = split(line2, " ", cols2);
    for (i = 0; i < count; i++) {
        v = atoi(cols2[i]);
        if (i == 0 && v == 0) break;
        if (v > n) continue;
        list2[v] = 1;
    }
    count = split(line3, " ", cols3);
    for (i = 0; i < count; i++) {
        v = atoi(cols3[i]);
        if (i == 0 && v == 0) break;
        if (v > n) continue;
        list3[v] = 1;
    }
    count = 0;
    for (i = 0; i < MAX_LEN; i++) {
        if (list3[i]) {
            if (!list2[i]) {
                result[i] = 1;
                count++;
            }
        }
    }
    if (count == 0) {
        printf("None\n");
    } else {
        first = 1;
        for (i = 0; i < MAX_LEN; i++) {
            if (result[i]) {
                if (!first) printf(" ");
                printf("%d", i);
                first = 0;
            }
        }
    }
    return 0;
}
