#include<stdio.h>
void fun(int N){
    if(N==0) return;
    fun(N-1);
    printf("%d\n", N);
}
int main(){
    int N;
    scanf("%d", &N);
    fun(N);
return 0;
}