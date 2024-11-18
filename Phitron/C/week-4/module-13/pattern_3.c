//     *
//    ***
//   *****
//  *******
// *********

#include<stdio.h>
int main(){
    int N,k, m=1;
    scanf("%d",&N);
    k=N-1;
    for (int i = 0; i<N; i++){
        for(int j= 1; j<=k;j++){
            printf(" ");
        }
        k--;
        for(int x = 1; x<=m;x ++){
            printf("*");
        }
        printf("\n");
        m+=2;
    }
return 0;
}
