#include<stdio.h>
void fun(int N){
    if(N==0) return;
    int A, B;
    scanf("%d %d", &A, &B);
    if(A==B){
        printf("Square\n");
    }
    else{
        printf("Rectangle\n");
    }
    fun(N-1);
}
int main(){
    int N;
    scanf("%d", &N);
    fun(N);
}