// 0 0 0
// 0 0 0
// 0 0 0


#include<stdio.h>
int main(){
    int m, n, count =0;
    scanf("%d %d",&m, &n);
    int element=m*n;
    int arr[m][n];
    for(int i =0; i<m;i++){
        for(int j=0; j<n;j++){
            scanf("%d", &arr[i][j]);
        }
    }
    for(int i =0; i<m;i++){
        for(int j=0; j<n;j++){
            //scanf("%d", &arr[i][j]);
            if(arr[i][j]==0){
                count++;
            }
        }
    }
    if(element==count)
    printf("zero matrix");
return 0;
}