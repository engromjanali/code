#include<stdio.h>
#include<string.h>

int main(){
    char arr[1001];
    gets(arr);
    int count [26]={0};
    for(int i =0; i<strlen(arr);i++){
        int val = arr[i] -'a';
        count[val]++;
    }
    for(int i = 0; i<26; i++){
        printf("%c - %d\n", i+97,count[i]);
    }
    return 0;
}
