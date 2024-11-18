#include<stdio.h>
int main(){
    int a,i,x=0;
    scanf("%d", &a);
    for(i=1;i<=a;i++){
        if(i%2==0){
            printf("%d\n", i);
            x++;
        }
    }
    if(x==0){
        printf("-1");
    }
return 0;
}