#include<stdio.h>
void fun(){
    printf("hii");
    fun();
}
int main(){
    fun();
return 0;
}