#include<stdio.h>
#include<limits.h>
int fun(int arr[], int N, int i){

    if(i==N){
        return INT_MIN;
    }
    int x = fun(arr, N, i+1);
    if(x<arr[i]){
        return arr[i];
    }
    else{
        return x;
    }
}
int main(){
    int N; 
    scanf("%d", &N);
    int arr[N];
    for(int j = 0; j<N; j++){
    scanf("%d", &arr[j]);
    }
    int x = fun(arr,N, 0);
    printf("%d", x);

}