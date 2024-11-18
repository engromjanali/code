// #include<stdio.h>
// #include<string.h>
// int main(){
//     char arr[1001];
//     char test[1001];

//     int ans = 1;

//     int j = 0;
//     gets(arr);
//     for(int i = strlen(arr)-1; i>=0; i--){
//         test[j] = arr[i];
//         j++;
//     }
//     for(int i = 0; i<strlen(arr); i++){
//         if(arr[i] != test[i]){
//             ans = 0;
//             break;
//         }
//     }

//     if(ans==1){
//         printf("YES");
//     }
//     else{
//         printf("NO");
//     }
    
// return 0;
// }



#include<stdio.h>
#include<string.h>
int main(){
    char arr[1001];
    int ans = 1;

    gets(arr);
    int i = 0, j = strlen(arr)-1;

    for(i; i<strlen(arr)/2; i++){
        if(arr[i] != arr[j]){
            ans = 0;
            break;
        }
        j--;
    }
    if(ans==0){
        printf("NO");
    }else{
        printf("YES");
    }
return 0;
}