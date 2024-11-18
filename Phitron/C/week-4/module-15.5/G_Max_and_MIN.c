//maxvalue 
#include<stdio.h>
void min_maxresult(int  * arr,int N){
    for( int i =0; i<N-1; i++){
        for(int j = i+1; j<N; j++){
            if(arr[i]>arr[j]){
                arr[i] = arr[i]+arr[j];
                arr[j] = arr[i]-arr[j];
                arr[i] = arr[i]-arr[j];
            }
        }
    }
    printf("%d %d ", arr[0], arr[N-1]);
}

void min_max(int N){
    int arr[N];
    for(int i =0; i<N; i++){
        scanf("%d", &arr[i]);
    }
    min_maxresult(arr, N);
}
int main(){
    int N;
    scanf("%d", &N);
    min_max(N);
return 0;
}