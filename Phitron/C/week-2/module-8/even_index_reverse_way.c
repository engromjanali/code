#include<stdio.h>
int main(){
    int N;
    scanf("%d", &N);
    int numbers [N];
    for(int i = 0 ; i < N; i ++){
        scanf("%d", & numbers[i]);
    }


    for(int i = N-1; i>=0; i--){
        if(i%2==0){
        printf("%d ", numbers[i]);
        }
    }

return 0;
}