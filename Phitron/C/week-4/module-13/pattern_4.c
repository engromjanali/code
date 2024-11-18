// *********
//  *******
//   *****
//    ***
//     *
#include<stdio.h>
int main(){
    int N,S=0, K;
    scanf("%d", &N);
    K=(2*N)-1;
    for(int i = 0; i<N; i++){
        for (int j =0;j<S;j++ ){
            printf(" ");
        }
        S++;
        
        for(int j= 0; j<K;j++ ){
            printf("*");
        }
        K-=2;
        printf("\n");
    }
    
    return 0;
}

