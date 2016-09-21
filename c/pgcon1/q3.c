//プログラムコンテスト
//C言語用
//ファイル名 q3.c
//作成者 
#include <stdio.h>

int main() {
	int x, y, s, max, s1, v0, s20, s2, v1, v2;
	scanf("%d", &x);
	scanf("%d", &y);
	scanf("%d", &s);
	max = 0;
	for (s1=1; s1<s; s1++) {
		v0 = s1*(100+x)/100;
		s20 = (s-v0)*100/(100+x);
		for (s2=s20-10; s2<s20+10; s2++) {
			if (s2 <= 0 || s1+s2 < 0 || s1+s2 > s) continue;
			v1 = s1*(100+x)/100 + s2*(100+x)/100;
			if (v1 != s) continue;
			v2 = s1*(100+y)/100 + s2*(100+y)/100;
			if (v2 > max) {
				max = v2;
			}
		}
	}
	printf("%d\n", max);
	return 0;
}
