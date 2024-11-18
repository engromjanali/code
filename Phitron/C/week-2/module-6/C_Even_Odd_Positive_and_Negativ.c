#include<stdio.h>
int main(){
    int input,i,even=0,N,odd=0,positive=0,negetive=0;
    scanf("%d",&N);
    for(i=1; i<=N; i++){
            scanf("%d",&input);
            if(input>0){
                positive++;
            }
            if(input<0){
                negetive++;
            }
            if(input%2==0){
                even++;
            }
            else{
                odd++;
            }
    }
    printf("Even: %d\nOdd: %d\nPositive: %d\nNegative: %d",even,odd,positive,negetive);
return 0;
}