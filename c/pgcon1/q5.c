//プログラムコンテスト
//C言語用
//ファイル名 q5.c
//作成者 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LEN ( 100 )

typedef struct tagNode {
	int cost;
	char next[27];
} Node;

Node nodes[26];
char answerPath[27];
int answerCost;
char line[MAX_LEN];
char *cols[MAX_LEN];

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

void addPrev(char cur, char prev) {
	char *next;

	next = nodes[prev-'A'].next;
	while (*next) next++;
	*next = cur;
}

void check(char *path, int cost) {
	if (cost > answerCost) {
		answerCost = cost;
		strcpy(answerPath, path);
	} else if (cost == answerCost) {
		if (strcmp(path, answerPath) < 0) {
			strcpy(answerPath, path);
		}
	}
}

void seek(char cur, char *path, int cost) {
    char buf[27];
    char *ptr;
    
    for (ptr=path; *ptr; ptr++) {
        if (*ptr == cur) return;
    }
    strcpy(buf, path);
    for (ptr=buf; *ptr; ptr++) ;
    *ptr++ = cur;
    *ptr = '\0';
    cost += nodes[cur-'A'].cost;
    //printf("%s,%d\n", buf, cost);
    check(buf, cost);
    for (ptr=nodes[cur-'A'].next; *ptr; ptr++) {
        seek(*ptr, buf, cost);
    }
}

int main() {
	int job, i, j, count, v, n;
	char cur, prev;

	fgets(line, sizeof(line), stdin);
	job = atoi(line);
	for (i=0; i<job; i++) {
		fgets(line, sizeof(line), stdin);
		count = split(line, " ", cols);
		cur = cols[0][0];
		v = atoi(cols[1]);
		n = atoi(cols[2]);
		nodes[cur-'A'].cost = v;
		if (cur == 'A') continue;
		for (j=0; j<n; j++) {
			prev = cols[3+j][0];
			addPrev(cur, prev);
		}
	}
    seek('A', "", 0);
    printf("%s\n", answerPath);
    return 0;
}
