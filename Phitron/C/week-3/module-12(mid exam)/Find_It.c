#include<stdio.h>
int main(){
    int N,count=0;
    scanf("%d", &N);
    int arr[N];
    for(int i =0; i<N; i++){
        scanf("%d", &arr[i]);
    }
    int x;
    scanf("%d", &x);
    for(int i =0; i<N;i++){
        if(x==arr[i]){
            count++;
        }
    }
    printf("%d", count);

return 0;
}