#include<stdio.h>
int main(){
    int N, M;
    scanf("%d%d",&N,&M);
    int arr[N][M];
    for(int i =0; i<N; i++){
        for(int j=0; j<M; j++){
            scanf("%d", &arr[i][j]);
        }
    }
    for(int j=0; j<M;j++){
        printf("%d ", arr[N-1][j]);
    }
    printf("\n");
    for(int j=0; j<N;j++){
        printf("%d ", arr[j][M-1]);
    }
    return 0;
}