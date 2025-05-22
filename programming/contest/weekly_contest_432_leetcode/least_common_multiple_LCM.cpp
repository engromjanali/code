// 18 = (2 * 9) = (2 * 3 * 3)
// 12 = (2 * 6) = (2 * 2*  3)
// LCM = (2 * 2 * 3 * 3)// WHERE HAVE DIVISOR OF "A" AND DIVISOR OF "B". (like sortest common supersequence)

int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

int lcm(int a, int b) {
    return (a / gcd(a, b)) * b; // 18/6*12= 3*12 = 3*2*2*4 or 2*2*3*3
}

#include<bits/stdc++.h>
using namespace std;

int main(){
    

return 0;
}