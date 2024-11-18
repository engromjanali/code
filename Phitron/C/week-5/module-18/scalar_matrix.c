    // a   0   0
    // 0   a   0
    // 0   0   a

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
                    if(arr[i][j]!=arr[0][0]){
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
            printf("scalar matrix.");
        }
        else{
            printf("Not scalar.");
        }
    return 0;
    }
