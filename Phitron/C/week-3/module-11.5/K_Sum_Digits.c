#include<stdio.h>
#include<string.h>
int main(){
    int N,sum=0;
    scanf("%d",&N);
    char arr[N];
    scanf("%s", arr);
    for(int i=0; i<strlen(arr);i++){
        sum+=arr[i]-48;
    }
    printf("%d", sum);
return 0;
}/