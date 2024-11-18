// #include<stdio.h>
// int main(){
//     //char arr[5]={'s','d','g','d','d'};
//     char arr[5]= "sdgdd";  //it's valid also, and it's a super power.
//     for(int i = 0; i<5; i++){
//         printf("%c ",arr[i]);
//     }
// return 0;
// }


// we get the currect output but the we get few garbaz data in last also.
// the couse is array size. string need a (/0) in last of array, if we assigen any value by double codation we get auto maticlly /0 in last as invisible. that's why we have to declear char array as string by 1 extra index/size.
// the extra index store /0.
#include<stdio.h>
int main(){
    //char arr[5]={'s','d','g','d','d'};
    //char arr[6]= "sdgdd";  // we have decleare 1 extra size.
    char arr[6]= "sdgdd";  //we know we don't need decleare size for this type initilization.
    // we can print the char array as string also.
    printf("%s", arr);
return 0;
}