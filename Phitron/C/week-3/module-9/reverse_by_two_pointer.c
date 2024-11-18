#include<stdio.h>
int main(){
    int N;
    scanf("%d", &N);
    int numbers [N];
    for(int i = 0; i<N; i++){
        scanf("%d", &numbers[i]);
    }int i,j;
    i = 0; 
    j = N-1;
    while(i<j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
        i++;
        j--;
    }
    for(int i = 0 ; i<N; i++){
        printf("%d ", numbers[i]);
    }
return 0;
}