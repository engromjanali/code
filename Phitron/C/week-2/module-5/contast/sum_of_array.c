#include<stdio.h>
int main(){
int sum , n;
scanf("%d", &n);
int number[n];
for(int i = 0; i<n; i++ ){
    scanf("%d",&number[i] );
}
for (int i=0; i<n; i ++){
    sum += number[i];
}

printf(" sumantion = %d", sum );
return 0;
}