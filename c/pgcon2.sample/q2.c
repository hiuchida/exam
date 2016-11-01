#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#pragma warning(disable:4996)

#define IN_MAX 4096
int compCard(const void *a, const void *b);

#define RTRIM(in) \
{\
	int cc;\
	for(cc=strlen(in)-1;cc>=0;cc--){\
		if(in[cc] == ' '){\
			in[cc] = '\0';\
		}\
		else{\
			break;\
		}\
	}\
}

struct M_CARD{
	short	Mark;
	short	Number;
	char	MarkC;
	char	NumberC;
}CARD[13*4+1];
int		CardN;

int main( int argc, char **argv )
{
	char	in[IN_MAX];

	int		i;
	char	*tmp;
	int		Mark, First;

	memset( CARD, '\0', sizeof(CARD) );

	fgets(in, sizeof(in), stdin);
	if( in[strlen(in)-1] == '\n' ) in[strlen(in)-1] = '\0'; 
	RTRIM( in );

	CardN = 0;

	if( tmp = strtok( in, " " ) ){
		do{
			CARD[CardN].MarkC = *tmp;
			switch( *tmp ){
				case 'S':
					CARD[CardN].Mark = 1;
					break;
				case 'D':
					CARD[CardN].Mark = 2;
					break;
				case 'C':
					CARD[CardN].Mark = 3;
					break;
				case 'H':
					CARD[CardN].Mark = 4;
					break;
			}

			CARD[CardN].NumberC = tmp[1];

			if( tmp[1] == 'A' ){
				CARD[CardN].Number = 1;
			}
			else if( tmp[1] == '0' ){
				CARD[CardN].Number = 10;
			}
			else if( tmp[1] == 'J' ){
				CARD[CardN].Number = 11;
			}
			else if( tmp[1] == 'Q' ){
				CARD[CardN].Number = 12;
			}
			else if( tmp[1] == 'K' ){
				CARD[CardN].Number = 13;
			}
			else{
				CARD[CardN].Number = tmp[1] - 0x30;
			}
			CardN++;
		}while( tmp = strtok( NULL, " " ));

		qsort( CARD, CardN, sizeof(M_CARD), compCard );


		Mark = 0;
		for( i=0; i<CardN; i++ ){
			if( Mark != CARD[i].Mark ){
				if( Mark != 0 ){
					printf( "\n", CARD[i].MarkC );
				}
				printf( "%c:", CARD[i].MarkC );
				Mark = CARD[i].Mark;
				First = 1;
			}

			if( First ){
				First = 0;
			}
			else{
				printf( "," );
			}
			printf( "%c", CARD[i].NumberC );
		}
		printf( "\n" );
	}

	return( 0 );


}

int compCard(const void *a, const void *b)
{
	M_CARD	*a1, *b1;

	a1 = (M_CARD *)a;
	b1 = (M_CARD *)b;

	if( a1->Mark == b1->Mark ){
		return a1->Number - b1->Number;
	}
	else return a1->Mark - b1->Mark;

}
