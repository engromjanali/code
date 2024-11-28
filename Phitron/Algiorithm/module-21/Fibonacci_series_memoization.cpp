#include<bits/stdc++.h>
#define ll long long int
using namespace std;
vector<ll>arr;
ll fib(ll n) //O(N).
{
    if(n<=1) return 1;
    if(arr[n] != -1) return arr[n];

    ll a= fib(n-1);
    ll b= fib(n-2);

    arr[n]=a+b;
    return arr[n];
}

int main(){
ll n;
cin>>n;
arr.resize(n,-1);
for(ll i =0; i<n; i++)
{
    cout<<fib(i)<<endl;
}
    

return 0;
}