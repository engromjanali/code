#include<stdio.h>
#include<string.h>

int main(){
    char arr[1001];
    gets(arr);
    int upper =0, lower =0;
    for(int i=0; i<strlen(arr);i++){
        if(arr[i]>=65&&arr[i]<=90){
            upper++;
        }
        else{
            lower++;
        }
    }
    printf("%d %d",upper, lower);

return 0;
}