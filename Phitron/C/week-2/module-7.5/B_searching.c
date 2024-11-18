
//https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/C
#include<stdio.h>
int main(){
    int N,X, res = -1;
    scanf("%d", &N);
    int A[N];
    for(int  i = 0; i<N; i++){
        scanf("%d", & A[i]);
    }
    scanf("%d", & X);

    for (int i  = 0; i<N; i ++){
        if(A[i]==X){
            res = i;
            break;
        }
    }
    printf("%d", res);

return 0;
}