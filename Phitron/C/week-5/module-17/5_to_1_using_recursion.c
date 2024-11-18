#include<stdio.h>
void fun(int i){
    if(i==0) return;//base case.
    printf("%d\n",i);
    fun(i-1);
}
int main(){
    int i;
    scanf("%d", &i);
    fun(i);
return 0;
}
