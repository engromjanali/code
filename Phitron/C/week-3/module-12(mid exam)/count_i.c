#include<stdio.h>
int main(){
    int N, even=0, odd=0;
    scanf("%d", &N);
    int arr[N];

    for(int i = 0; i< N;i++){
        scanf("%d", & arr[i]);
        if(arr[i]%2==0){
            even++;
        }
        else{
            odd++;
        }
    }
    printf("%d %d", even, odd);



return 0;
}