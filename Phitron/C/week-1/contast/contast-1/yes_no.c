#include<stdio.h>
int main(){
    int N, i;
    scanf("%d", &N);

    for(i=1;i<=N;i++){
        if(i%5==0){
            printf("%d Yes\n", i);
        }
        else{
            printf("%d No\n",i);
        }
    }
    
}