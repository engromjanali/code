#include<stdio.h>
int main(){
    int N;
    scanf("%d", &N);
    int arr[ N];
    for(int i =0; i<N; i++){
        scanf("%d", & arr[i]);
    }
    for(int i =0; i<N-1; i++){
        for(int j =i+1; j<N; j++){
            if(arr[i]>arr[j]){
            arr[i]+=arr[j];
            arr[j]=arr[i]-arr[j];
            arr[i]=arr[i]-arr[j];
            }
        }
    }

    if(N%2==0){
        printf("%d %d", arr[N/2-1],arr[ N/2]);
    }
    else{
        printf("%d", arr[(N-1)/2]);
    }
return 0;
}