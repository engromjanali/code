#include<stdio.h>
int main(){
    int N, M;
    scanf("%d",&N);
    int numbers[N];

    for (int i = 0; i<N; i ++){
        scanf("%d ", &numbers[i]);
    }

    scanf("%d", &M);
    int numbers_2 [M];

    for(int i = 0; i<M;i++){
        scanf("%d",&numbers_2[i]);
    }

    int number_3[N+M];
    for(int i = 0; i<N; i++){
       number_3[i]= numbers[i];
    }
    int i = N;
    for(int j = 0; j<M; j++){
        number_3[i] = numbers_2[j];
        i++;
    }
     for(i = 0; i<N+M; i++){
        printf("%d ", number_3[i]);
     }

return 0;
}