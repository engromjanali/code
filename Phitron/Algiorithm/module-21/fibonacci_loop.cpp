#include<bits/stdc++.h>
using namespace std;
#define ll long long

int main(){

    ll n;
    cin>>n;
    ll arr[n]={1,1};
    for(ll i =2; i<n; i++)
    {
        arr[i]= arr[i-1] + arr[i-2];
    }
    cout<<arr[n-1];

return 0;
}