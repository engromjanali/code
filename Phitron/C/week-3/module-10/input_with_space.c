// #include<stdio.h>
// #include<string.h>

// int main(){
//     char F_name[14];
//     gets(F_name); //gets work like scanf but it's take full line.
// return 0;
// }

#include<stdio.h>
#include<string.h>

int main(){
    char F_name[14];
    fgets(F_name,14,stdin); // fgets size is more importent, array size dose not metter, but if array size is less then fgets size will will get (signementation fault, run time error) for another oprating system and online.  // fgets take new line.
return 0;
}