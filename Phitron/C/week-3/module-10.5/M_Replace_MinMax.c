#include<stdio.h>
int main(){
    int N;
    scanf("%d", &N);
    int arr[N];


    for(int i = 0; i<N; i++){
        scanf("%d", &arr[i]);
    }
    int min = arr[0], min_index =0;
    int max = arr[0], max_index=0;

    for(int i = 0; i<N; i++){
        if(min>arr[i]){
            min= arr[i];
            min_index = i;
        }
        else if(max <arr[i]){
            max= arr[i];
            max_index = i;
        }
    }
    arr[max_index] =arr[max_index] + arr[min_index];
    arr[min_index] = arr[max_index] - arr[min_index];
    arr[max_index] = arr[max_index] - arr[min_index];

    for(int i = 0 ; i<N; i++){
        printf("%d ", arr[i]);
    }
 return 0;
}