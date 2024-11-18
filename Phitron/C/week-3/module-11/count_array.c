#include<stdio.h>
int main(){
    int arr[100];
    int N ;
    scanf("%d", &N);
    for(int i = 0; i<N;i++){
        scanf("%d", &arr[i]);
    }
    int count[10]={0};//all index value = 0;
    for(int i =0; i<N; i++){
        int val = arr[i];
        count[val]+=1;
    }
    for(int i = 0; i<10; i++){
        printf("%d - %d\n",i , count[i]);
    }

return 0;
}