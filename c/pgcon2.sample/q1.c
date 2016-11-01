#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#pragma GCC diagnostic ignored "-Wunused-result"

#define	IN_MAX 4096

int main(int argc, char** argv)
{
	char	in[IN_MAX];

	int		i;

	fgets(in, sizeof(in), stdin);
	if( in[strlen(in)-1] == '\n' ) in[strlen(in)-1] = '\0'; // 改行コードを取る

	for(  i = strlen(in)-1; i>=0; i-- ){ // 最後の文字から逆順に最初の文字まで
		printf( "%c", in[i] );
	}
	printf( "\n" );

	return 0;
}
