//プログラムコンテスト
//C言語用
//ファイル名 q2.c
//作成者 
#include <stdio.h>

#define MAX_LEN ( 100 )

char line[MAX_LEN];
int table[3][3];

int main() {
    int i, j, blank;
	int s1, s2, s3, s4, s5, s6, s7, s8;
    
    for (i=0; i<3; i++) {
        fgets(line, sizeof(line), stdin);
        for (j=0; j<3; j++) {
            if (line[j] == 'o') {
                table[i][j] = 1;
            } else if (line[j] == 'x') {
                table[i][j] = -1;
            } else if (line[j] == '-') {
                table[i][j] = 0;
            } else {
                printf("Illegal Input Data");
                return 1;
            }
        }
    }
    blank = 0;
    for (i=0; i<3; i++) {
        for (j=0; j<3; j++) {
            if (table[i][j] == 0) {
                blank++;
            }
        }
    }
    s1 = table[0][0] + table[0][1] + table[0][2];
    s2 = table[1][0] + table[1][1] + table[1][2];
    s3 = table[2][0] + table[2][1] + table[2][2];
    s4 = table[0][0] + table[1][0] + table[2][0];
    s5 = table[0][1] + table[1][1] + table[2][1];
    s6 = table[0][2] + table[1][2] + table[2][2];
    s7 = table[0][0] + table[1][1] + table[2][2];
    s8 = table[2][0] + table[1][1] + table[0][2];
    if (s1 == 3 || s2 == 3 || s3 == 3 || s4 == 3 || s5 == 3 || s6 == 3 || s7 == 3 || s8 == 3) {
    	printf("WIN\n");
    } else if (s1 == -3 || s2 == -3 || s3 == -3 || s4 == -3 || s5 == -3 || s6 == -3 || s7 == -3 || s8 == -3) {
    	printf("LOSE\n");
    } else if (blank == 0) {
    	printf("FIN\n");
    } else if (blank % 2 == 0) {
    	printf("NG\n");
    } else if (s1 == 2 || s2 == 2 || s3 == 2 || s4 == 2 || s5 == 2 || s6 == 2 || s7 == 2 || s8 == 2) {
    	printf("OK\n");
    } else {
    	printf("NO\n");
    }
    return 0;
}
