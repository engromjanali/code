#include<stdio.h>
int main(){
    int a=10000,i,pass;
    //scanf("%d",&a);
    for(i=1;i<=a;i++){
        scanf("%d",&pass);
        if(pass==1999){
            printf("Correct\n");
            break;
            
        }
        else{
            printf("Wrong\n");
        }
    }
return 0;
}