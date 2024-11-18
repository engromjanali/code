#include<stdio.h>
#include<string.h>
int main(){
    char a [11];
    char b [11];
    gets(a);
    gets(b);
    int A = strlen(a);
    int B = strlen(b);

    printf("%d %d\n", A, B);
    printf("%s%s\n",a,b);
    char temp = a[0];
    a[0]= b[0];
    b[0] = temp;
    printf("%s %s",a,b);
    
return 0;

}