#include <stdio.h>
int main(){
    int N;
    scanf("%d", &N);
    int k = N;

    for(int i = 0; i<N; i++){
        for(int j =0; j<k; j++){
            printf("*");
        }
        k--;
        printf("\n");
    }
}