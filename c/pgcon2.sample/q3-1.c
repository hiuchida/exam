#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#pragma warning(disable:4996)

#define IN_MAX   4096

int main( )
{
	char	in[IN_MAX];
	char	*p1;
	int		r=0, g=0, b=0;

	fgets(in, sizeof(in), stdin);
	if( in[strlen(in)-1] == '\n' ) in[strlen(in)-1] = '\0'; 

	r = g = b = 0;
	p1 = in;
	while( *p1 ){
		switch( *p1 ){
			case 'R':
				r++;
				break;
			case 'G':
				g++;
				break;
			case 'B':
				b++;
				break;
			default:
				break;
		}
		p1++;
	}
	r %= 2;
	g %= 2;
	b %= 2;

	printf( "%d\n", r+g+b );

	return 0;
}
