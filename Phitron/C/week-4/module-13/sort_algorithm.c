// assending (1 2 3 4 5)
#include<stdio.h>
int main(){
    int N;
    scanf("%d", &N);
    int arr[N];
    for(int i =0; i<N;i++){
        scanf("%d", &arr[i]);
    }
    //sorting assending.
    for(int i =0; i<N-1; i++){
        for(int j=i+1; j<N;j++){
            if(arr[i]>arr[j]){
                arr[i]= arr[i]+arr[j];
                arr[j]= arr[i]-arr[j];
                arr[i]=arr[i]-arr[j];
            }
        }
    }
    for(int i =0; i<N;i++){
        printf("%d ", arr[i]);
    }
return 0;
}

// assending (5 4 3 2 1)
#include<stdio.h>
int main(){
    int N;
    scanf("%d", &N);
    int arr[N];
    for(int i =0; i<N;i++){
        scanf("%d", &arr[i]);
    }
    //sorting dessending.
    for(int i =0; i<N-1; i++){
        for(int j=i+1; j<N;j++){
            if(arr[i]<arr[j]){
                arr[i]= arr[i]+arr[j];
                arr[j]= arr[i]-arr[j];
                arr[i]=arr[i]-arr[j];
            }
        }
    }
    for(int i =0; i<N;i++){
        printf("%d ", arr[i]);
    }
return 0;
}

