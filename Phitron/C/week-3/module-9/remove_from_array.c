#include<stdio.h>
int main(){
    int N;
    scanf("%d", &N);
    int arr[N];
    for(int i = 0; i<N; i ++){
        scanf("%d", &arr[i]);
    }
    int position;
    scanf("%d", &position);
    for(int i = position; i<N-1; i++){
        arr[i]=arr[i+1];
    }
    for(int i = 0; i<N-1; i++){
        printf("%d ", arr[i]);
    }

return 0;
}