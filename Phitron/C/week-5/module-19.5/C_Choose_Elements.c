#include<stdio.h>
int main(){
    long long int N, K;
    scanf("%lld %lld", &N, &K);
    long long int arr[N ];
    for(int i =0; i< N; i++){
        scanf("%lld", &arr[i]);
    }
//sorting
    for(int i=0; i<N-1; i++){
        for(int j=i+1; j<N;j++){
            if(arr[i]<arr[j]){
            arr[i]+=arr[j];
            arr[j]=arr[i]-arr[j];
            arr[i]= arr[i]-arr[j];
            }
        }
    }

    long long int sum=0;
    for(int i=0; i<K;i++){
        sum+=arr[i];
    }
    printf("%lld", sum);
}
