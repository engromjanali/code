#include<stdio.h>
int main(){
    int N,K;
    scanf("%d %d",&N,&K);
    for(int i = 0; i<K; i++){
        for(int i =1; i<=N;i++){
            printf("%d ",i);
        }
        printf("\n");
    }
return 0;
}