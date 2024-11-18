#include<stdio.h>
int main(){
    char a[100];
    scanf("%s", a);
    int x=0;
    for(int i = 0; a[i]!='\0'; i++){
        x++;
    }

    printf("%d", x);
return 0;
}
//
// #include<stdio.h>
// #include<string.h>
// int main(){
//     char a[100];
//     scanf("%s", a);

//     int x = strlen(a);
//     printf("%d", x);
// return 0;
// }