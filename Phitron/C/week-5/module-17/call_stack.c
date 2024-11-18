#include<stdio.h>
void world(){
    printf("i ma world\n");
}
void hello(){
    printf("i ma hello\n");
    world();
}
int main(){
    hello();
    world();
return 0;
}