#include<stdio.h>
long long int fun(int arr[], int N  ){
    if(N==-1) return 0;
    long long int count =fun(arr, N-1);
    count += arr[N];
    return count;
}
int main(){
    int N;
    scanf("%d", &N);
    int arr[N];
    for(int i =0; i<N; i++){
        scanf("%d", &arr[i]);
    }
    printf("%lld", fun(arr, N-1));
return 0;
}