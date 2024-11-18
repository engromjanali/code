// input :
// 3
// 123 
// 1243
// 131235436  
// output :
// 1 2 3
// 1 2 4 3
// 1 3 1 2 3 5 4 3 6


#include<stdio.h>
void fun(int n){
    if(n==0) {
        return;
    }
    int x= n%10;
    fun(n/10);
    printf("%d ",x);
}
int main(){
    int N;
    scanf("%d", &N);
    for(int i=0; i<N; i++){
        int n;
        scanf("%d", &n);
        fun(n);
        if(n==0) printf("0");
    }
return 0;
}