#include<stdio.h>
int main(){
    int N;
    scanf("%d",&N);
    int arr[N+1];
    for(int i = 0 ; i<N; i++){
        scanf("%d", & arr[i]);
    }
    int position, element;
    scanf( "%d %d", &position, &element);
    for(int i = N ; i>=position; i--){
        arr[i]= arr[i-1];
    }
    arr[position]= element;
    for(int i = 0; i<=N; i++){
        printf("%d ", arr[i]);
    }
return 0;
}