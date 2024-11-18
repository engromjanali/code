//lower to upper and upper to lower.

#include<stdio.h>
int main(){
    char X;
    scanf("%c", &X);
    if(X>=65 && X<=90){// it's uppercase letter 
    X+=32;
    printf("%c", X); 
    }
    else if(X>=97 && X<=122){
        X=X-32;
        printf("%c", X);
    }
}

// #include <stdio.h>

// int main() {
//     char letter;
    
//     // Input letter from user
//     printf("Enter a letter: ");
//     scanf("%c", &letter);
    
//     // Convert letter based on its case
//     if (letter >= 'a' && letter <= 'z') {
//         // Convert lowercase letter to uppercase
//         letter = letter - 32; // ASCII difference between lowercase and uppercase
//     } else if (letter >= 'A' && letter <= 'Z') {
//         // Convert uppercase letter to lowercase
//         letter = letter + 32; // ASCII difference between uppercase and lowercase
//     }
    
//     // Print converted letter
//     printf("Converted letter: %c\n", letter);
    
//     return 0;
// }
