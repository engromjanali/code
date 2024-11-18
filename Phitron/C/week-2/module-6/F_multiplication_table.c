#include<stdio.h>
int main(){
    int N,res,i;
    scanf("%d", &N);
    for(i=1; i<=12;i++){
        res = N*i;
        printf("%d * %d = %d\n",N,i,res);
    }
return 0;
}