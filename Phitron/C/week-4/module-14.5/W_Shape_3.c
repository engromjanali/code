#include <stdio.h>
int main(){

    int N; 
    scanf("%d", &N);
    int K = N-1;
    int Z =1;
    for(int i =0; i<N; i++){
        for(int j = 0; j<K; j++){
            printf(" ");
        }
        for(int j =0 ; j<Z; j++){
            printf("*");
        }
        Z+=2;
        K--;
        printf("\n");
    }
    int S =0;
    K = 2*N-1;
    for(int i =0; i<N; i++){
        for(int j = 0; j<S; j++){
            printf(" ");
        }
        for(int j = 0; j<K; j++){
            printf("*");
        }
        printf("\n");
        S++;
        K-=2;
    }
}
