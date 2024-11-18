#include<stdio.h>
#include<string.h>
int main(){
    char arr[100001];
    gets(arr);
    int a = strlen(arr);
    for(int i = 0; i<a; i++){
        if(arr[i]== ','){
            arr[i] = ' ';
        }
        if(arr[i] >= 65 && arr[i] <=90){
            arr[i] = arr[i]+32;
        }
        else if(arr[i] >= 97 && arr[i] <=122){
            arr[i] = arr[i]-32;
        }
    }
    printf("%s", arr);
return 0;
}