// combination = digit**check box.// checkbox = how many digit password. and digit = how many char caN used.

// ab-- aa,bb,ab,ba,--(2**2=4)
// b1-- b1,1b,11,bb-- (2**2=4)
// abc-- ab,ac,ba,bc,ca,cb,aa,bb,cc --(3**2=9)



// একই অপারেটর একবার এর বেশি ব্যবহার করা যাবে না only for the problem. but for combination have to use.
#include<stdio.h>
int main(){
    //int a,b,c;
    long long int a,b,c, d;
scanf("%lld %lld %lld %lld", &a,&b,&c,&d);

if (d==(a+b-c)){//if (a+b-c) it's value geter then int value it's don't work proparly. that's why we sould use long long int of all of them.
    printf("YES");
}
else if (d==(a+b*c)){
    printf("YES");
}
else if (d==(a-b+c)){
    printf("YES");

}
else if (d==(a-b*c)){
    printf("YES");
}
else if (d==(a*b+c)){
    printf("YES");
}
else if (d==(a*b-c)){
    printf("YES");
}

else{
    printf("NO");
}
}


// int main() {
//     long long a, b, c, d;
//     scanf("%lld %lld %lld %lld", &a, &b, &c, &d);

//     int found = 0;

//     // Try all possible combinations of operators
//     if (a + b + c == d) found = 1;
//     if (a + b - c == d) found = 1;
//     if (a + b * c == d) found = 1;
//     if (a - b + c == d) found = 1;
//     if (a - b - c == d) found = 1;
//     if (a - b * c == d) found = 1;
//     if (a * b + c == d) found = 1;
//     if (a * b - c == d) found = 1;
//     if (a * b * c == d) found = 1;

//     // Output
//     if (found)
//         printf("YES\n");
//     else
//         printf("NO\n");

//     return 0;
// }