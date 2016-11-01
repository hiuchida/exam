#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#pragma warning(disable:4996)
#pragma GCC diagnostic ignored "-Wunused-result"

#define IN_MAX   4096
#define MAX_TITLE 10
#define MAX_MOVIE (MAX_TITLE * 10)
#define VIEWLISTMAX 512

char	Title[MAX_TITLE][128];
int		Interval;
typedef struct {
	int		TitleNo;
	int		Start;
	int		End;
}M_Movie;

int		MovieN = 0;
int		TitleN = 0;
int		ViewN  = 0;
int		MaxViewN = 0;
int		ViewListN = 0;

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


M_Movie	Movie[MAX_MOVIE];
M_Movie	*View[MAX_TITLE];
struct M_ViewList{
	int		ViewN;
	M_Movie	*Save[MAX_TITLE];
}ViewList[VIEWLISTMAX];

int Time2Num( char *s );
int compMovie(const void *a, const void *b);
int compViewList(const void *a, const void *b);
int SearchMovie( int MovieC, int	ViewN );



int main(int argc, char** argv)
{
	char	in[IN_MAX];
	int		furubon_count=0, motteru_count=0;


	int		i, j;
	char	*tmp;
	int		InputN;


	fgets(in, sizeof(in), stdin);
	if( in[strlen(in)-1] == '\n' ) in[strlen(in)-1] = '\0'; 
	RTRIM(in);

	InputN = atoi(in);

	fgets(in, sizeof(in), stdin);
	if( in[strlen(in)-1] == '\n' ) in[strlen(in)-1] = '\0'; 
	RTRIM(in);

	Interval = atoi(in);

	// 入力は保証されているのでチェックはしない

	for( i=0; i<InputN; i++ ){
		fgets(in, sizeof(in), stdin);
		if( in[strlen(in)-1] == '\n' ) in[strlen(in)-1] = '\0'; 
		RTRIM(in);

		if( tmp = strtok( in, " " ) ){
			strcpy( Title[TitleN], tmp );

			while( tmp = strtok( NULL, " " ) ){
				Movie[MovieN].TitleNo = TitleN;
				Movie[MovieN].Start = Time2Num( tmp );  
				Movie[MovieN].End   = Time2Num( strtok( NULL, " " ) );  
				MovieN++;
			}

			TitleN++;
		}
	}

	qsort( Movie, MovieN , sizeof(M_Movie), compMovie );

	SearchMovie( 0, 0 );

	qsort( ViewList, ViewListN, sizeof(M_ViewList), compViewList ); 

	printf( "%d\n", MaxViewN );

	int ViewCount = 0;
	for( i=0;i<ViewListN;i++ ){
		if( ViewList[i].ViewN == MaxViewN ){
			ViewCount++;
		}
	}

	printf( "%d\n", ViewCount );

	int		MaxTitleLen = 0;
	for( i=0; i<TitleN; i++ )if( strlen(Title[i])>MaxTitleLen) MaxTitleLen=strlen(Title[i]);

	for( i=0; i<ViewListN && i < 1; i++ ){
		if( ViewList[i].ViewN == MaxViewN ){
			if( i != 0 ) printf( "-\n" );
			for( j=0; j<ViewList[i].ViewN; j++ ){
				printf( /*"%02.02d:*/ "%-*s %02.02d:%02.02d %02.02d:%02.02d %d\n",
//					ViewList[i].Save[j]->TitleNo, 
					MaxTitleLen,
					Title[ViewList[i].Save[j]->TitleNo], 
					ViewList[i].Save[j]->Start/60, ViewList[i].Save[j]->Start%60,
					ViewList[i].Save[j]->End/60,   ViewList[i].Save[j]->End%60,
					( j != 0 )? ViewList[i].Save[j]->Start - ViewList[i].Save[j-1]->End : 0
					);
			}
		}
	}
}
int SearchMovie( int MovieC, int ViewN )
{
	int		Find, i;

	if( ViewN <= TitleN ){

		while(MovieC<MovieN){
			Find = 0;
			for( i=0; i<ViewN; i++ ){
				if( Movie[MovieC].TitleNo == View[i]->TitleNo ){
					Find = 1;
				}
			}
			if( !Find ){

				if( ViewN != 0 ){
					if( View[ViewN-1]->End + Interval <= Movie[MovieC].Start ){
						View[ViewN] = &Movie[MovieC];
						SearchMovie( MovieC+1, ViewN+1 );
					}
				}
				else{
					View[ViewN] = &Movie[MovieC];
					SearchMovie( MovieC+1, ViewN+1 );
				}
			}
			MovieC++;
		}
		if( ViewN >= MaxViewN ){
			MaxViewN = ViewN;
			ViewList[ViewListN].ViewN = ViewN;
			for( i=0; i<ViewN; i++ ){
				ViewList[ViewListN].Save[i] = View[i];
			}
			if(ViewListN>=VIEWLISTMAX){
				printf("Give UP\n");
				exit(-1);
			}
			ViewListN++;
		}
	}
	return 0;
}




int compMovie( const void *a1, const void *b1)
{
	M_Movie *a, *b;

	a = (M_Movie *)a1;
	b = (M_Movie *)b1;

	if( a->Start == b->Start ){
		if( a->End == b->End ){
			return b->TitleNo - a->TitleNo;
		}
		else return a->End - b->End;
	}
	else return a->Start - b->Start;
}

int compViewList( const void *a1, const void *b1)
{
	M_ViewList *a, *b;
	int		i;

	a = (M_ViewList *)a1;
	b = (M_ViewList *)b1;

	if( a->ViewN == b->ViewN ){
		if( a->Save[0]->Start == b->Save[0]->Start ){
			for( i=0; i<a->ViewN; i++ ){
				if( a->Save[i]->TitleNo != b->Save[i]->TitleNo ){
					return a->Save[i]->TitleNo - b->Save[i]->TitleNo;
				}
			}
			return 0;
		}
		else return b->Save[0]->Start - a->Save[0]->Start;
	}
	else return b->ViewN - a->ViewN;
}

int Time2Num( char *s )
{
	int h, m;
	char	*p;

	p = strchr( s, ':' );
	*p++ = '\0';

	h = atoi( s );
	m = atoi( p );

	return( h * 60 + m );
}
