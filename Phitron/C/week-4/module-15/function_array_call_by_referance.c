// function receive address of array, they don't create new array just take address of the fast_created array,
// so if we change any value of any index the changes will be effected in main array.
// it's call pass by reference.

#include<stdio.h>
#include<string.h>
void fun(char pntr []){ // we can get string length from function also. that's why we don't need array size. 
    
    printf("%d\n", strlen(pntr));
    pntr[3]= 'H';
}
int main(){
    char arr []="md romjan ali";
    fun(arr);
    printf("%s", arr);
    return 0;
}