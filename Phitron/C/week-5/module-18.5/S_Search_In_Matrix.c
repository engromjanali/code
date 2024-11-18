#include<stdio.h>
int main(){
    int M, N;
    scanf("%d %d", &M, &N);
    int arr[M][N];
    for(int i=0; i<M;i++){
        for(int j =0; j<N; j++){
            scanf("%d", &arr[i][j]);
        }
    }
    int K; 
    scanf( "%d", &K);
    int flag = 0;
    for(int i=0; i<M;i++){
        for(int j = 0; j<N; j++){
            if(K==arr[i][j]){
                flag =1;
            }
        }
    }
    if(flag==1){
        printf("will not take number");
    }
    else{
        printf("will take number");
    }

return 0;
}