#include<stdio.h>
int main(){
    int N,i,input;
    scanf("%d", &N);
    for(i=1; i<=N;i++){
        scanf("%d", & input);
        do{
            int digit = input%10;
            printf("%d ", digit);
            input/=10;
        }
        while(input!=0);
        printf("\n");
    }
return 0;
}