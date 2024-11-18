#include<stdio.h>
int main(){
    char X;
    scanf("%c", &X);
    if(X>='0'&& X<='9'){
        printf("IS DIGIT");
    }
    else if(X>='A' && X<='Z'){
        printf("ALPHA\nIS CAPITAL");
    }
    else if(X>=97 && X<=122){
        printf("ALPHA\nIS SMALL");
    }
}