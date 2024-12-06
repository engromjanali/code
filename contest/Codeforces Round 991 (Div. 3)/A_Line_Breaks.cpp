#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin>>t;
    while(t--)
    {
        int n,m;
        cin>>n>>m;
        vector<string>s;
        for(int i =0; i<n; i++)
        {
            string st;
            cin>>st;
            s.push_back(st);
        }
        int ans =0;
        for(int i =0; i<n; i++)
        {
            if(s[i].size() <= m)
            {
                m -= s[i].size();
                ans++;
            }
            else break;
        }
        cout<<ans<<endl;
    }

return 0;
}