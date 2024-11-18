#include<stdio.h>
void fun(int N){
    int count1=0,count2=0;
    for(int i =0; i<N; i++){
        int A, B;

        scanf("%d%d", &A, &B);

        if(A>B){
            count1++;
        }
        else if(B>A){
            count2++;
        }
    }
    if(count1 > count2){
        printf("Tiger");
    }
    else if(count1==count2){
        printf("Draw");
    }
    else{
        printf("Pathan");
    }
}
int main(){
    int N;
    scanf("%d", &N);
    fun(N);
return 0;
}