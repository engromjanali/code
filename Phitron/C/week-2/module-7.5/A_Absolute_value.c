#include<stdio.h>
int main(){
    int N  ;
    long long int sum=0;
    scanf("%d",&N);
    int A [N];
    for (int  i = 0; i<N; i++){
        scanf("%d", & A[i]);
    }
    for (int j = 0; j<N; j++){
        sum += A[j];
    }
if(sum <0){
      printf("%lld", sum*-1);
}
else{
    printf("%lld", sum);
}
return 0;
}
