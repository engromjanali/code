#include<stdio.h>
int sum (){
    int x,y;
    scanf("%d %d", &x, &y);
    return -2;   // Fast return work. after it others return won't work.
    int summ = x+y;
    return summ;
}
int main(){
    int x = sum(100);
        printf("%d", x);
return 0;
}


//OUTPUT : -2