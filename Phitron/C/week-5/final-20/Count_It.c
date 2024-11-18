#include<stdio.h>
int main(){
    char arr[1001];
    fgets(arr,1001,stdin);
    int Ccount=0, Scount=0,Space=0;
    for(int i=0; arr[i]!='\0'; i++){
        if(arr[i] >=65 && arr[i]<=90){
            Ccount++;
        }
        else if(arr[i] >=97 && arr[i]<=122){
            Scount++;
        }
        else if(arr[i]==' '){
            Space++;
        }
    }

    printf("Capital - %d\nSmall - %d\nSpaces - %d",Ccount,Scount,Space);
return 0;
}