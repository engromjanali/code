#include<stdio.h>
int main(){
    int a,i ;
    long long int r;
    printf("enter the value of A : ");
    scanf("%d", &a);
    for( i=1; i<=a; i++){
        //r+=i;
        if(i%2==0){
            printf("%d - even\n", i);
        }
        else{
            printf("%d - odd\n", i);
        }
    }
    //printf("%lld",r);
}