#include<stdio.h>
int x = 100; // it's golobal variable because the variable can access by all function.
void xyz(){
    printf("%d", x);
}
int main(){
    y = 200; // it's local variable.
    printf("%d\n", x);
    xyz();
return 0;
}

