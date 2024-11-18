#include<stdio.h>
int fun(int N){
    if(N==0) return 1;
    int fact = fun(N-1);
    fact*=N;
    return fact;

}
int main(){
    int N;
    scanf("%d", &N);
    printf("%d", fun(N));
}