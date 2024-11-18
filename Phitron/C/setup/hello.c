#include<stdio.h>
int main(){
    //printf("hello world!");

    int i =10;
    for(i; i<100;i){
        int n;
        n=i++;
        printf("%d\n",n);
    }
return 0;
}