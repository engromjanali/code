#include<stdio.h>
int main(){
    int X;
    scanf("%d",  &X);
    
    while(X>=10){
        X= X/10;//for fast digit
        //X= X%10; // for last digit
    }
    if(X%2 ==0 ){
        //printf("%d", X);
        printf("EVEN");
    }
    else{
        printf("ODD");
    }
}