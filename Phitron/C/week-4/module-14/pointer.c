// #include<stdio.h>
// int main(){
//     int x;

//     printf("%p\n", &x);
// return 0;
// }
// // 2nd way 
// #include<stdio.h>
// int main(){
//     int x;
//     int * adss = &x;

//     printf("%p\n", adss);
// return 0;
// }

// value access by pointer ;
// #include<stdio.h>
// int main(){
//     int x=10;
//     int * adss = &x;

//     printf("%d\n", *adss);
// return 0;
// }

// change value of x by pointer 

#include<stdio.h>
int main(){
    int x;
    int * adss = &x;

    * adss = 20;

    printf("%d\n", *adss);
return 0;
}