//function can't be written under of main function.
// but thare are one way to write in under of main method.
//for this we have to decleare the method upper of main method.

#include<stdio.h>
int sum(int x, int y);
int main(){
    int x = sum(10,5);
    printf("%d", x);
}
int sum(int x, int y){
    int result = x+y;
    return result;
}