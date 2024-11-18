#include<stdio.h>
int main(){
int N;
scanf("%d", &N);
int arr[N][N];
// input array elements
for(int i =0; i<N; i++){
    for( int j =0; j<N; j++){
        scanf("%d", &arr[i][j]);
    }
}   
// checking
int flag = 1;
for(int i =0; i<N; i++){
    for( int j =0; j<N; j++){
        if(i==j){
            if(arr[i][j]!=1){
                flag = 0;
                break;
            }
        }
        else{
            if(arr[i][j]!=0){
                flag =0;
            }
        }
    }
} 
if(flag==1){
    printf("YES");
}
else{
    printf("NO");
}
return 0;
}