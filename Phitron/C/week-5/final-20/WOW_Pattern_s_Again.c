//      ^
//     ***
//    ^^^^^
//   *******
//  ^^^^^^^^^
// ***********




#include<stdio.h>
int main(){
    int N;
    scanf("%d", &N);
    int j=1,k=N-1;

    for(int i=1; i<=N; i++){
        if(i%2==0){
            for(int ii= 0; ii<k;ii++){
                printf(" ");
            }
            k--;
            for(int ii= 0; ii<j;ii++){
                printf("*");
            }
        }
        else{
            for(int ii= 0; ii<k;ii++){
                printf(" ");
            }
            k--;
            for(int ii= 0; ii<j;ii++){
                printf("^");
            }
        }
        j+=2;
        printf("\n");
    }
return 0;
}