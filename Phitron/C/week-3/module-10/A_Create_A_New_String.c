#include<stdio.h>
#include<string.h>
int main(){
    char a [1001];
    char b [1001];
    scanf("%s",a);
    scanf("%s", b);
    int x,y;
    x = strlen(a);
    y = strlen(b);
    printf("%d %d\n", x,y);
    char c [x+y+2];  //extra 2 index. 1 for \0 and 1 for ' '
    for(int i = 0; i<x; i++){
        c[i]= a[i];
    }
    int j = x;
    c[j]=' ';
    j++;
    for(int i = 0 ; i<y; i++){
        c[j]= b[i];
        j++;
    }
    c[x+y+1]= '\0';
    printf("%s", c);
return 0;
}


