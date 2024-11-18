#include <stdio.h>

int main() {
    int A, B;

    scanf("%d %d",&A, &B);
    if(A%B==0){
        printf("multiple");
    }
    else if( B%A==0){
        printf("multiple");
    }
    else{
        printf("No Multiples");
    }

    return 0;
}

// exceptaed code.

#include<stdio.h>
int main()
{
    int A,B;
    scanf("%d%d",&A,&B);
    if(A%B==0 || B%A==0){
        printf("Multiples");
    }
    else{
        printf("No Multiples");
    }
    return 0;
}