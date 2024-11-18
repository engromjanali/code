// // fast way
// #include<stdio.h>

// void fun(int arrs[], int N){// arrs can't take size of arr that's why we have to receive size of arr also.
//     for(int i =0; i<N; i++){
//         printf("%d\n", arrs[i]);
//     }
// }

// int main(){
// int arr[5]={10,20,30,40,50};
// fun(arr,sizeof(arr)/sizeof(int));
// return 0;
// }

// 2nd way
#include<stdio.h>

void fun(int * p, int N){ // here we take name of array just. because array name is a pointer. who take 0th index address of array. 
    for(int i =0; i<N; i++){
        printf("%d\n", *p);//0th index
        printf("%d\n", p[i]);//0th index  // p[i] -> *(p+i)
    }
}

int main(){
int arr[5]={10,20,30,40,50};
fun(arr,sizeof(arr)/sizeof(int));
return 0;
}