#include<stdio.h>
#include<string.h>
int main(){
    char a [1000001];
    gets(a);
    for(int i = 0; a[i]!= '\\'; i++){
        printf("%c", a[i]);
    }
return 0;
}