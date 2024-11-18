//     *
//    ***
//   *****
//  *******
// *********
//  *******
//   *****
//    ***
//     *
    
// #include <stdio.h>
// int main(){
//     int N, S,K=1;
//     scanf("%d", &N);
//     S= N-1;
//     for(int i =1; i<=(N*2)-1; i++){
//         for(int j = 1; j<=S;j++){
//             printf(" ");
//         }
        
//         for(int j=1;j<=K;j++){
//             printf("*");
//         }
        
//         printf("\n");
//         if(i<=N-1){
//             S--;
//             K+=2;
//         }
//         else{
//             S++;
//             K-=2;
//         }
//     }
//     return 0;
// }
#include <stdio.h>
int main(){
    int N, S,K=1;
    scanf("%d", &N);
    S= N-1;
    for(int i =1; i<=N; i++){
        for(int j = 1; j<=S;j++){
            printf(" ");
        }
        S--;
        for(int j=1;j<=K;j++){
            printf("*");
        }
        K+=2;
        printf("\n");
    }
    N--;
    S=1;
    K=(2*N)-1;
    for(int i =1; i<=N; i++){
        for(int j = 1; j<=S;j++){
            printf(" ");
        }
        S++;
        for(int j=1;j<=K;j++){
            printf("*");
        }
        K-=2;
        printf("\n");
    }
    return 0;
}