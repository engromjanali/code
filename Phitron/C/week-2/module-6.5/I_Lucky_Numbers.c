#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);

    int f = N/10; 
    int l = N%10; 

    if (f != 0 && l % f == 0) {
        printf("YES\n");
    } else if (l!= 0 && f % l == 0) {
        printf("YES\n");
    } else {
        printf("NO\n");
    }
    return 0;
}
