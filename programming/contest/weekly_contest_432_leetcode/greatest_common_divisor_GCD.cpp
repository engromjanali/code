// 12 and 18
// 12 -> 1,2,3,4,6,12
// 18 -> 1,2,3,6,9,18
// GCS IS = 6.
#include<bits/stdc++.h>
using namespace std;

// a = 12, b = 18 // initial
// a = 18 b = 12
// a = 12 b = 6
// a = 6 b = 0

// a = 5 b = 11 // initial
// a = 11 b = 5
// a = 5 b = 1
// a = 1 b =0

int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
