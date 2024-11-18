//https://codeforces.com/group/MWSDmqGsZm/contest/219432/problem/E

#include<stdio.h>
int main(){
    int i, N, input,max=0;
    scanf("%d",&N);
    for(i=1;i<=N;i++){
        scanf("%d", & input );
        if(max<input){
            max=input;
        }
    }
    printf("%d",max);
return 0;
}