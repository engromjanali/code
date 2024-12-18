#include<bits/stdc++.h>
using namespace std;

int main(){

    int t; cin>>t;
    while (t--)
    {
        int n; cin>>n;
        int ans =1;
        int current = 1;
        while (true)
        {
            if(current>=n) break;
            ans++;
            current= current*2 + 2;
        }
        cout<<ans<<endl;
    }
return 0;
}