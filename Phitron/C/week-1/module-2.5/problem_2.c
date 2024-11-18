#include<stdio.h>
int main(){
    int a , b;
    printf("enter the value of A : ");
    scanf("%d",&a);
    printf("enter the value of B : ");
    scanf("%d", &b);
    //cal(a, b);
    int sum = a+b;
    printf("\n%d + %d = %d",a,b,sum);
    int sub = a-b;
    printf("\n%d - %d = %d",a,b,sub);
    int mul = a*b;
    printf("\n%d x %d = %d",a,b,mul);
    float div = a*1.0/b;
    printf("\n%d / %d = %0.2f",a,b,div);
}
// int cal(int a ,int b){
//     int sum = a+b;
//     printf("\n%d + %d = %d",a,b,sum);
//     int sub = a-b;
//     printf("\n%d - %d = %d",a,b,sub);
//     int mul = a*b;
//     printf("\n%d x %d = %d",a,b,mul);
//     float div = a*1.0/b;
//     printf("\n%d / %d = %0.2f",a,b,div);

// }