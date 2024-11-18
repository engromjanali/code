#include<stdio.h>
void fun(long long int A, long long int B, long long int K){
    if(A%K==0&&B%K==0){
        printf("Both");
    }
    else if(A%K==0){
        printf("Memo");
    }
    else if(B%K==0){
        printf("Momo");
    }
    else{
        printf("No One");
    }
}
int main(){
    long long int A,B,K;
    scanf("%lld %lld %lld", &A,& B,& K);
    fun(A,B,K);
}