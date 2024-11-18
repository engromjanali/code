// call by value--------

#include<stdio.h>

int fun(int x){ // the x is defrind x,
    x = 200;
    printf("%d\n", x);
}

int main(){
    int x = 100;
    fun(x); // the x is defrind.
    printf("%d\n", x);
}