//  1   2   3  ->   3   2   1 |reflact 2d array 
//  4   5   6  ->   6   5   4 |reflact 2d array 
//  7   8   9  ->   9   8   7 |reflact 2d array 

#include<stdio.h>
void fun(int a, int b){
    int arr [a][b];
    for(int i =0; i<a; i++){
        for(int j =0; j<b; j++){
            scanf("%d", &arr[i][j]);
        }
    }
//current array    
    for(int i =0; i<a; i++){
        for(int j =0; j<b; j++){
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }
//refelect array / mirror array 
    for(int i =0; i<a; i++){
        for(int j =b-1; j>=0; j--){
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }

}
int main()
{
        int a, b; 
    scanf("%d %d", &a, &b);
    fun(a,b);
}