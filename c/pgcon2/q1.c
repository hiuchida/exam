#include <stdio.h>
#include <string.h>
int i;char b[9999];main(){gets(b);for(i=strlen(b)-1;i>=0;i--)printf("%c",b[i]);puts("");return 0;}
