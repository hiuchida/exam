#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#pragma warning(disable:4996)
#pragma GCC diagnostic ignored "-Wunused-result"

#define IN_MAX   4096
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
char	ScreenBuffer[25][81];
char	*Screen[25];
int		CursorX, CursorY;

/* Escape Sequence commands */

void CSR_DOWN( char * );
void CSR_UP( char * );
void CSR_LEFT( char * );
void CSR_RIGHT( char * );
void CSR_POS( char * );
void CLS(  );
void SCROOL( int );
void WRITE_CHAR( char *);
void PrintScreen();



void CLS(  )
{
	int		i;

	CursorX = 0;
	CursorY = 0;

	for( i=0;i<25;i++ ){
		strcpy( Screen[i], "                                                                                " );
	}
}

void CSR_UP( char *Command )
{
	CursorY -= atoi(Command);
	if( CursorY < 0 ){
		CursorY = 0;
	}
}

void CSR_DOWN( char *Command )
{
	CursorY += atoi(Command);
	if( CursorY > 24 ){
		CursorY = 24;
	}
}

void CSR_LEFT( char *Command )
{
	CursorX -= atoi(Command);
	if( CursorX < 0 ){
		CursorX = 0;
	}
}

void CSR_RIGHT( char *Command )
{
	CursorX += atoi(Command);
	if( CursorX > 79 ){
		CursorX = 79;
	}
}

void CSR_POS( char *Command )
{

	CursorY = atoi( strtok(Command,";") )-1;
	CursorX = atoi( strtok(NULL   ,";") )-1;
	if( CursorY < 0 ){
		CursorY = 0;
	}
	if( CursorY > 24 ){
		CursorY = 24;
	}
	if( CursorX < 0 ){
		CursorX = 0;
	}
	if( CursorX > 79 ){
		CursorX = 79;
	}

}

void WRITE_CHAR( char *Command )
{
	Screen[CursorY][CursorX] = *Command;
	CursorX++;
	if( CursorX >= 80 ){
		CursorX = 0;
		CursorY++;
		if( CursorY >=25 ){
			CursorY = 24;
			SCROOL( 1 );
		}
	}
}
void SCROOL( int n )
{
	int		j;
	char	*tmp;

	for( j=0; j<n; j++ ){
		tmp        = Screen[ 0];
		Screen[ 0] = Screen[ 1];
		Screen[ 1] = Screen[ 2];
		Screen[ 2] = Screen[ 3];
		Screen[ 3] = Screen[ 4];
		Screen[ 4] = Screen[ 5];
		Screen[ 5] = Screen[ 6];
		Screen[ 6] = Screen[ 7];
		Screen[ 7] = Screen[ 8];
		Screen[ 8] = Screen[ 9];
		Screen[ 9] = Screen[10];
		Screen[10] = Screen[11];
		Screen[11] = Screen[12];
		Screen[12] = Screen[13];
		Screen[13] = Screen[14];
		Screen[14] = Screen[15];
		Screen[15] = Screen[16];
		Screen[16] = Screen[17];
		Screen[17] = Screen[18];
		Screen[18] = Screen[19];
		Screen[19] = Screen[20];
		Screen[20] = Screen[21];
		Screen[21] = Screen[22];
		Screen[22] = Screen[23];
		Screen[23] = Screen[24];
		Screen[24] = tmp;
		strcpy( Screen[24], "                                                                                " );
	}
}

/***************************************************************/
int main( int argc, char **argv )
{
	char	in[IN_MAX], Command[128], *p, *p1;
	int		i;
	int		Line, B;
	

	fgets(in, sizeof(in), stdin);
	if( in[strlen(in)-1] == '\n' ) in[strlen(in)-1] = '\0'; 
	Line = atoi( in );

	for( i=0;i<25;i++ ){
		Screen[i] = ScreenBuffer[i];
	}

	CLS();

	for( ; Line>0; Line--){
		fgets(in, sizeof(in), stdin);
		if( in[strlen(in)-1] == '\n' ) in[strlen(in)-1] = '\0'; 

		p = in;

		while(*p){
			if( *p == '\x1b' ){
				p++;
				p++;
				p1 = p;
				B = 1;
				while(B){
					switch(*p1){
						case 'B':
							memcpy( Command, p, p1-p );
							Command[p1-p] = '\0';
							CSR_DOWN( Command );
							B = 0;
							break;
						case 'D':
							memcpy( Command, p, p1-p );
							Command[p1-p] = '\0';
							CSR_LEFT( Command );
							B = 0;
							break;
						case 'C':
							memcpy( Command, p, p1-p );
							Command[p1-p] = '\0';
							CSR_RIGHT( Command );
							B = 0;
							break;
						case 'A':
							memcpy( Command, p, p1-p );
							Command[p1-p] = '\0';
							CSR_UP( Command );
							B = 0;
							break;
						case 'H':
							memcpy( Command, p, p1-p );
							Command[p1-p] = '\0';
							CSR_POS( Command );
							B = 0;
							break;
						case 'J':
							memcpy( Command, p, p1-p );
							Command[p1-p] = '\0';
							CLS(  );
							B = 0;
							break;
						default:
							break;
					}
					p1++;
				}
				p = p1-1;
			}
			else{
				WRITE_CHAR( p );
			}
			p++;
		}
	}
	PrintScreen();
}

void PrintScreen()
{
	int		i;

	for( i=0; i<25; i++ ){
		printf( "%s\n", Screen[i] );
	}
}

/**************************************************/

