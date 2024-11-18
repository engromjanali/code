#include<stdio.h>
int main(){
    int N, even_sum=0, odd_sum=0;
    scanf("%d", &N);
    int numbers [N];
    for(int i = 0 ; i < N; i ++){
        scanf("%d", & numbers[i]);
    }
    for(int i = 0; i<N; i++){
        if(numbers[i]%2 ==0){
            even_sum += numbers[i]; 
        }
        else{
            odd_sum += numbers[i]; 
        }
    }
    printf( "%d %d",  even_sum, odd_sum);
return 0;
}