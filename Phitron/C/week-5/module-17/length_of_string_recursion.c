#include<stdio.h>
int fun(char a[], int i){
    if(a[i]=='\0') return 0;
    int res = fun(a,i+1);
    return res+1;
}
int main(){
    int x ;
    scanf("%d ", &x);
    char arr[x];
    gets(arr);
    int res= fun(arr,0);
    printf("the length of array is : %d", res);
}