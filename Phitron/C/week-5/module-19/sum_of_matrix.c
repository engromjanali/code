//  3   2   1  +   2   4   6 |-> summantion of the two array :  5   6   7 
//  3   2   1  +   2   4   6 |-> summantion of the two array :  5   6   7 
//  3   2   1  +   2   4   6 |-> summantion of the two array :  5   6   7 

#include<stdio.h>
void fun(int a, int b){
    int arr [a][b];
    int arr2 [a][b];
    int arrresult [a][b];
//input of array-1 
    for(int i =0; i<a; i++){
        for(int j =0; j<b; j++){
            scanf("%d", &arr[i][j]);
        }
    }
// input of array-2
    for(int i =0; i<a; i++){
        for(int j =0; j<b; j++){
            scanf("%d", &arr2[i][j]);
        }
    }
// summantion of the two array 
    for(int i =0; i<a; i++){
        for(int j =0; j<b; j++){
            arrresult[i][j] = arr[i][j] + arr2[i][j];
        }
    }
// output of summantion result
    for(int i =0; i<a; i++){
        for(int j =0; j<b; j++){
            printf("%d\t", arrresult[i][j]);
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
