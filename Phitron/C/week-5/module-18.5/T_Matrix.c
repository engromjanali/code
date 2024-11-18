#include<stdio.h>
#include<stdlib.h>

int main(){
    int N;
    scanf( "%d", &N);
    int arr[N][N];
    for(int i = 0; i<N; i++){
        for(int j= 0; j<N; j++){
            scanf("%d", &arr[i][j]);
        }
    }

    int count_1=0;
    for(int i =0; i<N; i++){
        for(int j =0; j<N;j++){
            if(i==j){
                count_1+= arr[i][j];
            }
        }
    }

    int count_2=0;
    for(int i =0; i<N; i++){
        for(int j =0; j<N;j++){
            if(i+j==N-1){
                count_2 += arr[i][j];
            }
        }
    }
    printf("%d",abs(count_1-count_2));
    


return 0;
}