#include<stdio.h>
void fun(int N){
    if(N==0) return;
    printf("I love Recursion\n");
    fun(N-1);  
}
int main(){
    int N;
    scanf("%d", &N);
    fun(N);
return 0;
}