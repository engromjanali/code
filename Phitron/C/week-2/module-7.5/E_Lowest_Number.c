//https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/E
#include<stdio.h>
int main(){
    int N  , position=1;
    scanf("%d",&N);
    int A [N];
    for (int  i = 0; i<N; i++){
        scanf("%d", & A[i]);
    }
    int  lowest= A[0];

    for (int j = 0; j<N; j++){
        if (lowest > A[j]){
            lowest = A[j];
            position = j+1;
        }
    }
    printf("%d %d", lowest, position);
return 0;
}
