#include <stdio.h>
int main(){
    int i;
    for (i=1 ; i<=10; i++){
        if(i==7){
            continue;// print all without 7th line
        }
        printf("%d hello romjan ali, how are you?\n", i);
    }
}