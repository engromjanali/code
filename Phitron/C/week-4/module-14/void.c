#include<stdio.h>
int sum (){//paramiter is null.
    int x,y;
    scanf("%d %d", &x, &y);
    int summ = x+y;
    return summ;
}
int main(){
    int x = sum(100);// we have pass 100 as argument the function ignore the argument. because the function don't have paramiter.
    printf("%d", x);
return 0;
}


// #include<stdio.h>
// int sum (void){//the void has use to decleare the function don't recive argument.
//     int x,y;
//     scanf("%d %d", &x, &y);
//     int summ = x+y;
//     return summ;
// }
// int main(){
//     int x = sum(100);  // we have pass 100 as argument. the function don't recive argument, and the function decleare by void paramiter. that's why here will accure a error. here won't ignore argumrnt, acure a error. 
//         printf("%d", x);
// return 0;
// }