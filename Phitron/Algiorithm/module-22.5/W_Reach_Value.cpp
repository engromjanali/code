
// https://codeforces.com/group/MWSDmqGsZm/contest/223339/my
#include<bits/stdc++.h>
using namespace std;
bool recursion(long long a, long long n)
{
    if(a>n) return false;
    if(a==n) return true;
    return (recursion(a*10 , n) || recursion(a*20 , n));
}
int main(){

    int n;
    cin>>n;
    while(n--)
    {
        long long a; cin>>a;
        if(recursion((long long)1,a))
            cout<<"YES"<<endl;
        else cout<<"NO"<<endl;
    }

return 0;
}