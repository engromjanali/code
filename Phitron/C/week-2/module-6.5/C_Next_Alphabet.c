#include<stdio.h>
int main(){
    char c;
    scanf("%c",&c);
    if(c==122){
        printf("%c",'a');
    }
    else if(c<=122 && c>=97){
        c++;
        printf("%c",c);
    }
return 0;
}

