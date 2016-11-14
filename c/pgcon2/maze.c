#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LEN ( 10000 )
#define _intMax ( 2147483647 )
typedef int boolean;
#define true  ( 1 )
#define false ( 0 )

int dx[] = { 1, 0, -1, 0 };
int dy[] = { 0, 1, 0, -1 };
char line[MAX_LEN];
char *cols[MAX_LEN];
int  n;
char map[100+2][100+2];
int  history[100+2][100+2];
char walk[100+2][100+2];
int  answerCnt;
long funcCnt;

void initMap() {
	int i, x, y;
	
	fgets(line, sizeof(line), stdin);
	n = atoi(line);
	for (int i=0; i<n+2; i++) {
		map[0][i] = 1;
		map[n+1][i] = 1;
		map[i][0] = 1;
		map[i][n+1] = 1;
	}
	for (int y=1; y<=n; y++) {
		fgets(line, sizeof(line), stdin);
		for (int x=1; x<=n; x++) {
			if (line[x-1] == '#') {
				map[y][x] = 1;
			}
		}
	}
}

void initHistory(boolean bMin) {
	int x, y;
	int def = bMin ? _intMax : -1;
	for (int y=1; y<=n; y++) {
		for (int x=1; x<=n; x++) {
			history[y][x] = def;
		}
	}
	answerCnt = def;
	funcCnt = 0;
}

void printMap(boolean bMin) {
	int x, y;
	int def = bMin ? _intMax : -1;
	for (int y=0; y<=n+1; y++) {
		for (int x=0; x<=n+1; x++) {
			if (map[y][x]) printf("#");
			//else if (answerSet.contains(new Point(x, y))) printf("o");
			//else if (history[y][x] != def) printf("x");
			else printf(".");
		}
		printf("\n");
	}
	printf("\n");
}

boolean checkMin(int x, int y, int cnt) {
	if (map[y][x]) {
		return true;
	}
	if (x == n && y == n) {
		if (cnt < answerCnt) {
			answerCnt = cnt;
		}
		return true;
	}
	return false;
}

boolean isMoveMin(int x, int y, int cnt) {
	if (map[y][x]) {
		return false;
	}
	if (cnt >= history[y][x]) {
		return false;
	}
	return true;
}

void searchDFSMin(int x, int y, int cnt) {
	int i;
	funcCnt++;
	if (funcCnt % 100000000 == 0) printf("%d\n", funcCnt/100000000);
	if (checkMin(x, y, cnt)) {
		return;
	}
	if (cnt >= history[y][x]) {
		return;
	}
	history[y][x] = cnt;
	cnt++;
	for (int i=0; i<4; i++) {
		if (isMoveMin(x+dx[i], y+dy[i], cnt)) {
			searchDFSMin(x+dx[i], y+dy[i], cnt);
		}
	}
}

boolean checkMax(int x, int y, int cnt) {
	if (map[y][x]) {
		return true;
	}
	if (x == n && y == n) {
		if (cnt > answerCnt) {
			answerCnt = cnt;
		}
		return true;
	}
	return false;
}

boolean isMoveMax(int x, int y, int cnt) {
	if (map[y][x]) {
		return false;
	}
	if (walk[y][x]) {
		return false;
	}
	return true;
}

void searchDFSMax(int x, int y, int cnt) {
	int i;
	funcCnt++;
	if (funcCnt % 100000000 == 0) printf("%d\n", funcCnt/100000000);
	if (checkMax(x, y, cnt)) {
		return;
	}
	if (walk[y][x]) {
		return;
	}
	walk[y][x] = true;
	cnt++;
	for (int i=0; i<4; i++) {
		if (isMoveMax(x+dx[i], y+dy[i], cnt)) {
			searchDFSMax(x+dx[i], y+dy[i], cnt);
		}
	}
	walk[y][x] = false;
}

int main() {
	initMap();
	initHistory(true);
	//printMap(true);
	searchDFSMin(1, 1, 0);
	//printMap(true);
	if (answerCnt == _intMax) {
		answerCnt = -1;
		printf("%d\n", answerCnt);
		printf("%d\n", answerCnt);
		return 0;
	}
	printf("%d\n", answerCnt);
	initHistory(false);
	searchDFSMax(1, 1, 0);
	//printMap(false);
	printf("%d\n", answerCnt);
	return 0;
}
