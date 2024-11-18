//  If the answer is a floating value, print the integer part of the answer.

#include<stdio.h>
int main(){
    int w1, w2, d;
    scanf("%d %d %d", &w1, &w2, &d);
    int permen = w1*d;
    int ans = permen/w2;
    printf("%d\n", ans);
    
return 0;
}


