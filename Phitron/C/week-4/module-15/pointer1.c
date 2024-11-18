#include<stdio.h>
int main(){
    int x = 10;
    int * p1 = &x;

    // multuple pointer for x,
    int * p2 = &x;
    // anoter method
    int * p3 = p1;
    printf("X er value - %d\n", x);
    printf("X er address - %p\n", &x);
    printf("X er address - %p\n", p1);
    printf("X er address - %p\n", p3);
    printf("X er value - %d\n",* p2);
    printf("X er value - %d\n",* p3);
return 0;
}