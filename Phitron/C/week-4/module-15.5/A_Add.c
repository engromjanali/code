#include<stdio.h>
void sum(int A, int B){
    int Result = A+B;
    printf("%d\n", Result);
}
int main(){
int A, B;
scanf("%d %d", &A, &B);
sum(A, B);
return 0;
}