// the white space is N/2+1


# include <stdio.h>
int main(){
    int N;
    scanf("%d", &N);
    int k = 1;
    int space = N-1;
    for(int i = 0; i <N ; i++){
        for(int j =0; j<space; j++){
            printf(" ");
        }
        space --;
        for( int j = 0; j<k; j++){
            printf("*");
        }
        k+=2;
        printf("\n");
    }
}