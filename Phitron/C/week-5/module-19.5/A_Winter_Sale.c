#include<stdio.h>
void fun(int X, int P){
    float nit_price= 100*(P/(100.00-X));
    printf("%.2f", nit_price);   
}
int main(){
    int X,P;
    scanf("%d %d", &X, &P);
    fun(X,P);
}