#include<stdio.h>
#include<string.h>
int main(){
    char arr[1000001];
    scanf("%s",arr);
    int sum =0;
    for(int i = 0; i<(strlen(arr)); i++){
        sum+=(arr[i]-'0'); // '0' = 48 // asscii value of '0' is 48
    }
    printf("%d", sum);
return 0;
}