    // 0   0   a
    // 0   b   0
    // c   0   0


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
                if(i+j==M-1){//00 11 22 for 3x3.
                    continue;
                }
                if(arr[i][j]!=0){
                    flag =0;
                    break;
                }
            }
        }
        if( flag==1){
            printf("secondery digonal.");
        }
        else{
            printf("Not digonal.");
        }
        
    return 0;
    }
