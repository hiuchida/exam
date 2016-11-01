#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#pragma warning(disable:4996)

#define IN_MAX   4096

void LoopAction( char *p, char	*inStack, short l );

int		Nest=0;
int		MinCount = 99;
int		CallN=0;

int main( )
{
	char	in[IN_MAX], dmyStack[2] = "";
	char	s[IN_MAX], *p1, *p2;;
	int		i;
	int	r=0, g=0, b=0;
	char	*rp, *gp, *bp;


	fgets(in, sizeof(in), stdin);
	if( in[strlen(in)-1] == '\n' ) in[strlen(in)-1] = '\0'; 

	LoopAction( in, dmyStack, 0 );

	printf( "%d\n", MinCount );

	return 0;
}
void LoopAction( char *p, char	*inStack, short l )
{
	char	saveStack[51];
	short	n;

	Nest++;
	CallN++;

	n =strlen(p);
	if( l != 0 && MinCount != 99 && n <= l - MinCount ){
		return;
	}

	if( *p == '\0' ){ // “ü—ÍI—¹
		if( l < MinCount ){
			MinCount = l;
		}
	}
	else{
		if( l == 0 ){
			saveStack[0] = *p;
			saveStack[1] = '\0';

			LoopAction( p+1, saveStack, 1 );
		}
		else if( l == 1 ){
			if( *inStack == *p ){
				saveStack[0] = '\0';

				LoopAction( p+1, saveStack, 0 );
			}
			else{
				saveStack[0] = *inStack;
				saveStack[1] = *p;
				saveStack[2] = '\0';

				LoopAction( p+1, saveStack, 2 );

				saveStack[0] = *p;
				saveStack[1] = *inStack;
				saveStack[2] = '\0';

				LoopAction( p+1, saveStack, 2 );
			}
		}
		else{
			//Right
			strcpy( saveStack, inStack );

			if( saveStack[l-1] == *p ){
				saveStack[l-1] = '\0';
				LoopAction( p+1, saveStack, l-1 );
			}
			else{
				saveStack[l]   = *p;
				saveStack[l+1] = '\0';
				LoopAction( p+1, saveStack, l+1 );
			}


			//Left
			if( inStack[0] == *p ){
				memcpy( saveStack, &inStack[1], l+1 );
				LoopAction( p+1, saveStack, l-1 );
			}
			else{
				memcpy( &saveStack[1], inStack, l+1 );
				saveStack[0] = *p;
				LoopAction( p+1, saveStack, l+1 );
			}
		}
	}
	Nest--;
}
