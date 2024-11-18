#include<stdio.h>
void fun(int arr[], int N){
    if(N==-1) return;
    if(N%2==0){
        printf("%d " , arr[N]);
    }
    fun(arr,N-1);
}
int main(){
    int N;
    scanf("%d", &N);
    int arr[N];
    for(int i =0; i<N;i++){
        scanf("%d", &arr[i]);
    }
    fun(arr, N-1);

return 0;
}