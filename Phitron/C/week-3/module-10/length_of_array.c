#include<stdio.h>
int main(){
    int arr[5];
    int length = sizeof(arr)/sizeof(arr[0]);//sizeof(arr) it's return how many byte of the array,  sizeof(arr[0]) it's return how array data type how many byte.// supose we get 16 byte as array size that's mean total array size is 20 byte we have to devide by array data type size like 20/4 (because int data type 4 byte) so now we get 20/4=5 it's mean array length 5. 
    int length = sizeof(arr)/4;  // 4 will be 1 for char, 4 will be 8 for double, 4 will be 4 for float.

return 0;
}

