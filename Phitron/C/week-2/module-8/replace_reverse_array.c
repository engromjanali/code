#include<stdio.h>
int main(){
    int N, X, V;
    scanf("%d", &N);
    int numbers [N];
    for(int i = 0 ; i < N; i ++){
        scanf("%d", & numbers[i]);
    }
    scanf("%d %d", &X , &V);
    numbers[X] = V;
    for(int i = N-1; i>=0; i--){
        printf("%d ", numbers[i]);
    }

return 0;
}