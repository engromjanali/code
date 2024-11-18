#include<stdio.h>
#include<string.h>
int main(){
    char arr[1001];
    int vawel=0;
    gets(arr);
    //for(int i =0;arr[i]!='\0'; i++){
    for(int i =0;i<strlen(arr); i++){
        if(arr[i]=='a'){
            vawel++;
        }

        if(arr[i]=='i'){
            vawel++;
        }
        if(arr[i]=='o'){
            vawel++;
        }
        if(arr[i]=='u'){
            vawel++;
        }
        if(arr[i]=='e'){
            vawel++;
        }
    }
    printf("%d", vawel);
return 0;
}