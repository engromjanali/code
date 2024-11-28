#include<bits/stdc++.h>
using namespace std;

int fib(int n) //O(2^N) max limit 20.
{
    if(n<=1) return 1;
    int a= fib(n-1);
    int b= fib(n-2);

    return a+b;
}

int main(){
int n;
cin>>n;
for(int i =0; i<n; i++)
{
    cout<<fib(i)<<endl;
}
    

return 0;
}