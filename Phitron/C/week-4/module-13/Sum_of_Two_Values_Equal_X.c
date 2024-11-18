#include<stdio.h>
int main(){
    int N;
    printf("enter length of arrray: ");
    scanf("%d",&N);
    int arr[N];
    for(int i =0; i<N; i++){
    scanf("%d",&arr[i]);
    }
    int X;
    scanf("%d",&X);
    //oration
    int j =0;
    for(int i= 0;i<N-1;i++){
        for(int j=i+1; j<N;j++){
           if(arr[i]+arr[j]==X){
                printf("YES\n");
            }
        }
    }
return 0;
}