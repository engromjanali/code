#include<stdio.h>
int main(){
    int tk;
    printf("enter the amount of money : ");
    scanf("%d", &tk);
    if( tk >= 5000){
        printf("\nwe will go to cox's bazer.");

        if ( tk >=10000){
        printf("\nwe will go to seadmartin.");
        }
    }
    else {
        printf("\nwe can't go any whare.");
    }
}