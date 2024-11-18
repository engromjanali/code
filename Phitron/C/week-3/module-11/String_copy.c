// we will get the value of B langth in A. because the "\0" of B array will be copy in A that's why we don't get after value of "\0".
#include<stdio.h>
#include<string.h>
int main(){
    char a [10];
    char b [5];
    scanf("%s %s", a,b);
    for(int i = 0; i<= strlen(b);i++){
        a[i]=b[i];
    }
    printf("%s %s", a,b);
return 0;
}


// b will be copy in a.
// #include<stdio.h>
// #include<string.h>
// int main(){

// char a[10], b[5];
// scanf("%s %s", a,b);

// strcpy(a,b);
// printf("%s %s",a,b);
// return 0;
// }