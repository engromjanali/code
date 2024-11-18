#include<stdio.h>
void fun(int i){
    if(i==6){//base case
    return;
    }
    fun(i+1);
    printf("%d\n", i);
}
int main(){
    int i;//i=1
    scanf("%d", &i);
    fun(i);
return 0;
}