#include<stdio.h>
int main(){
    int N, even_sum, odd_sum;
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
return 0;
}