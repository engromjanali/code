// return_type name(paramiter){
//     //statement
//     return result;
// }

// return type: 
// 1. int 
// 2. float 
// 3. double 
// 4. char 
// 5. boolean
// 6. void 




#include<stdio.h>
int sum(int a,int b){
    int result= a+b;
    return result;
}

int main(){
    int x = sum(10,5);
    printf("%d", x);
return 0;
}