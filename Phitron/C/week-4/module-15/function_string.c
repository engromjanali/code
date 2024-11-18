// // fast way by array 
// #include<stdio.h>
// #include<string.h>

// void fun(char arrs[]){ // we can get string length from function also. that's why we don't need array size. 
    
//     printf("%d\n", strlen(arrs));
//     printf("%s\n", arrs);
// }

// int main(){
//     char arr []="md romjan ali";
//     fun(arr);
//     return 0;
// }


// 2nd way by pointer 

#include<stdio.h>
#include<string.h>
void fun(char * pntr){ // we can get string length from function also. that's why we don't need array size. 
    
    printf("%d\n", strlen(pntr));
    printf("%s\n", pntr);
}
int main(){
    char arr []="md romjan ali";
    fun(arr);
    return 0;
}

