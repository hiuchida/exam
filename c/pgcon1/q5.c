//プログラムコンテスト
//C言語用
//ファイル名 q5.c
//作成者 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LEN ( 100 )

typedef struct tagNode {
	int point;
	char next[27];
} Node;

typedef struct tagPoint {
    char ids[27];
    int points;
} Point;

Node nodes[26];
Point pointList[100000];
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

void addPoint(char *ids, int points) {
    int i;
    
    for (i=0; pointList[i].ids[0]; i++) ;
    strcpy(pointList[i].ids, ids);
    pointList[i].points = points;
}

void seek(char cur, char *ids, int points) {
    char buf[27];
    char *ptr;
    
    for (ptr=ids; *ptr; ptr++) {
        if (*ptr == cur) return;
    }
    strcpy(buf, ids);
    for (ptr=buf; *ptr; ptr++) ;
    *ptr++ = cur;
    *ptr = '\0';
    points += nodes[cur-'A'].point;
    //printf("%s,%d\n", buf, points);
    addPoint(buf, points);
    for (ptr=nodes[cur-'A'].next; *ptr; ptr++) {
        seek(*ptr, buf, points);
    }
}

int main() {
	int job, i, j, count, v, n, maxVal, val;
	char cur, prev;
	char *maxKey, *key;

	fgets(line, sizeof(line), stdin);
	job = atoi(line);
	for (i=0; i<job; i++) {
		fgets(line, sizeof(line), stdin);
		count = split(line, " ", cols);
		cur = cols[0][0];
		v = atoi(cols[1]);
		n = atoi(cols[2]);
		nodes[cur-'A'].point = v;
		if (cur == 'A') continue;
		for (j=0; j<n; j++) {
			prev = cols[3+j][0];
			addPrev(cur, prev);
		}
	}
    seek('A', "", 0);
    maxKey = NULL;
    maxVal = 0;
    for (i=0; pointList[i].ids[0]; i++) {
        key = pointList[i].ids;
        val = pointList[i].points;
        if (val > maxVal) {
            maxKey = key;
            maxVal = val;
        } else if (val == maxVal) {
            if (strcmp(key, maxKey) < 0) {
                maxKey = key;
            }
        }
    }
    printf("%s\n", maxKey);
    return 0;
}
