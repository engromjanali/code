#include<stdio.h>
#include<string.h>
int main(){
    char A[21];
    char B[21];

    gets(A);
    gets(B);

    int x = strcmp(A, B);
    //printf("%d\n", x);  // -1 mean is A small, 0 mean A&B is equals, 1 mean is B is small. Toba sob somoy ja 1,-1 deba aita confirm na, but 0 taika soto ba 0 taika boro deba, soman hoila 0 deba confirm.
    if(x==0){
        printf("%s",A);
    }
    else if(x<0){
        printf("%s", A);
    }
    else if(x>0){
        printf("%s", B);
    }
    return 0;
}