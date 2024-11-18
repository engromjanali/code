// it's won't work because array length is too large.
// #include<stdio.h>
// #include<string.h>
// int main(){
//     //int N =5;
//     //scanf("%d", &N);
//     char arr[10000001];
//     gets(arr);
//     int count [26] = {0};
//     for(int i =0; i<strlen(arr); i++){
//         int val = arr[i]-'a';
//         count[val]++;
//     }

//     for( int i =0; i <26; i++){
//         if(count[i]!=0){
//         printf("%c : %d\n",i+97,count[i]);
//         }
//     }
// return 0;
// }

//another method
#include<stdio.h>
#include<string.h>
int main(){
    char ar;
    int count [26] = {0};
    while(scanf("%c", &ar) != EOF){//EOF mean when we type (ctrl+z) then enter the loop will be break.
        int val= ar -'a';
        count[val]++;
    }

    for( int i =0; i <26; i++){
        if(count[i]!=0){
        printf("%c : %d\n",i+97,count[i]);
        }
    }

return 0;
}