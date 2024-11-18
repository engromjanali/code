#include<stdio.h>
int main(){
    int a,i ;
    long long int r;
    printf("enter the value of A : ");
    scanf("%d", &a);
    for( i=1; i<=a; i++){
        r+=i;
    }
    printf("%lld",r);
}