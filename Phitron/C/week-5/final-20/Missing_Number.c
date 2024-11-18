#include<stdio.h>
#include<math.h>
int fun(int S, int A, int B, int C){
    int x= A+B+C;
    x= S-x;
    return x;
}
int main(){
    int N, S, B, C, A;
    scanf("%d", &N );
    for(int i=0; i<N; i++){
        scanf("%d %d %d %d ", &S, &B, &C, &A);
        int result = fun(S,B,C,A);
        printf("%d\n", result);
        
    }
}