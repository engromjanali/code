    // 1   0   0
    // 0   1   0
    // 0   0   1


    #include<stdio.h>
    int main(){
        int M,N;
        scanf("%d %d", &M, &N);
        int arr[M][N];
        for(int i =0; i<N; i++){
            for(int j=0; j<M; j++){
                scanf("%d", &arr[i][j]);
            }
        }
        int flag=1;
        if(M!=N){
            flag=0;
        }
        for(int i =0; i<N; i++){
            for(int j=0; j<M; j++){
                if(i==j){
                    if(arr[i][j]!=1){
                        flag=0;
                        break;
                    }
                    continue;
                }
                if(arr[i][j]!=0){
                    flag =0;
                    break;
                }
            }
        }
        if( flag==1){
            printf("unit matrix.");
        }
        else{
            printf("Not unit.");
        }
    return 0;
    }
