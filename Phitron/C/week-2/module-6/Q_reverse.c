#include<stdio.h>
int main(){
    int N,i,input, reverse=0;
    scanf("%d", &N);
    while(N!=0){
        int digit = N%10;// last degit
        printf("%d ", digit);
        reverse = reverse*10+digit;
        N/=10;//remove last degit 
    }
    printf("%d", reverse);
return 0;
}

// it's won't be correct because if we intput 0 to do reverse code programm print nothing, because with 0 input while loop condition will be false.
// #include<stdio.h>
// int main(){
//     int N,i,input;
//     scanf("%d", &N);
//     for(i=1; i<=N;i++){
//         scanf("%d", & input);
//         while(input!=0){// for input =0 make false.
//             int digit = input%10;
//             printf("%d ", digit);
//             input/=10;
//         }
//         printf("\n");
//     }
// return 0;
// }

// write ans.
// #include<stdio.h>
// int main(){
//     int N,i,input;
//     scanf("%d", &N);
//     for(i=1; i<=N;i++){
//         scanf("%d", & input);
//         do{
//             int digit = input%10;
//             printf("%d ", digit);
//             input/=10;
//         }
//         while(input!=0);
//         printf("\n");
//     }
// return 0;
// }