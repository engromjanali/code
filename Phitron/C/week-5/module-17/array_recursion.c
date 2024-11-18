#include<stdio.h>
void fun(int arr[],int N, int i){
    if(i==N) return;//base case
    printf("%d\n",arr[i]);
    fun(arr,N,i+1);
}

int main(){
    int N;
    scanf("%d",&N);
    int arr[N];
    for(int i=0; i<N; i++){
        scanf("%d", &arr[i]);
    }
    fun(arr, N, 0);
return 0;
}