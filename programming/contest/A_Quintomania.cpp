#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin>>t;
    while(t--)
    {
        int a;
        cin>>a;
        vector<int>v;
        while(a--)
        {
            int x;
            cin>>x;
            v.push_back(x);
        }
        reverse(v.begin(), v.end());
        a=v.back();
        v.pop_back();
        bool flag = true;
        while (!v.empty())
        {
            int x = v.back();
            v.pop_back();
            if(abs(x-a) ==5 || abs(a-x) == 7)
            {
                a = x;
            }
            else {
                flag = false;
                break;
            }
        }
        if(flag) cout<<"Yes"<<endl;
        else cout<<"No"<<endl;
    }

return 0;
}