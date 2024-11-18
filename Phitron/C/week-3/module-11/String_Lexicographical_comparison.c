// #include<stdio.h>
// #include<string.h>

// int main(){
    
//     char stringA [ 100];
//     char stringB [100];
//     scanf("%s %s", stringA, stringB);
//     int i = 0;
//     while(1){
//         if((stringA[i]=='\0')&&(stringB[i]=='\0')){
            
//             printf("A and B is Equals\n");
//             break;
//         }
//         else if(stringA[i]==stringB[i]){
//             i++;
//         }
//         else if(stringA[i]=='\0'){
//             printf("A is small\n");
//             break;
//         }
//         else if(stringB[i]=='\0'){
//             printf("B is small\n");
//             break;
//         }
//         else if(stringA[i]<stringB[i]){
//             printf("A is small\n");
//             break;
//         }
//         else if(stringA[i]>stringB[i]){
//             printf("B is small\n");
//             break;
//         }
//     }
// return 0;
// }


#include<stdio.h>
#include<string.h>

int main(){
    
    char stringA [ 100];
    char stringB [100];
    scanf("%s %s", stringA, stringB);
    int x = strcmp(stringA, stringB);
    printf("%d\n", x);  // -1 mean is A small, 0 mean A&B is equals, 1 mean is B is small. Toba sob somoy ja 1,-1 deba aita confirm na, but 0 taika soto ba 0 taika boro deba, soman hoila 0 deba confirm.
    if(x==0){
        printf("equals");
    }
    else if(x<0){
        printf("A is small");
    }
    else if(x>0){
        printf("B is small");
    }
    return 0;
}