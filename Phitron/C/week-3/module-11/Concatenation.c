//  that's mean A = A+B and B won't change.

// #include<stdio.h>
// #include<string.h>
// int main(){
//     char A [100];
//     char B [ 100];

//     scanf("%s %s", A , B);

//     int x = strlen(A);
//     for(int i = 0; i<=strlen(B); i++){
//         A[x] = B[i];
//         x++;
//     }
//     printf("%s %s\n", A,B);

// return 0;
// }


#include<string.h>
#include<stdio.h>
int main(){
    char A[100];
    char B [100];
    scanf("%s %s", A, B);
    strcat(A,B);
    printf("%s %s\n", A, B);
    return 0;
}