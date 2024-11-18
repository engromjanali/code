#include <stdio.h>
int main(){
    int a ;
    printf("enter the value of your walat : ");
    scanf("%d", & a);
    if ( a >=10000){
        printf("Gucci Bag");
        if(a>=20000){
            printf("\nGucci Belt");
        }
    }
    else if(a>=5000){
        printf("Levis Bag");
    }
    else{
        printf("Something");
    }
}