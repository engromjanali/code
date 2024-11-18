// behind the seen arr[i] -> *(arr+i)

#include<stdio.h>
int main(){
    int arr[5]= {10,20,30,40,50};
    //the name of a array is a pointer who store address of 0th index address.
    // we can access another index by array name , arr+N that's mean Nth index, arr+2 -> arr[2].
    printf("%p\n",arr); //0061FF0C
    printf("%p\n",&arr[0]); //0061FF0C

    // 3rd index address
    printf("%p\n", &arr[3]); //0061FF18
    printf("%p\n", (arr+3)); //0061FF18
    printf("%p\n", (3+arr)); //0061FF18
    printf("%p\n",& 3[arr]); //0061FF18

return 0;
}