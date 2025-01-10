#include<bits/stdc++.h>
using namespace std;

int main(){

    int n; cin>>n;
    long long arr[n];
    cin>>arr[0];
    for(int i =1; i<n; i++)
    {
        cin>>arr[i];
        arr[i]=arr[i]+arr[i-1];
    }
    for(int i = n-1; i>=0; i--)
    {
        cout<<arr[i]<<" ";
    }

return 0;
}