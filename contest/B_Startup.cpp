#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin>>t;
    while(t--)
    {
        int tak;
        cin>> tak;
        int n;
        cin>>n;
        priority_queue<int>v;
        while(n--)
        {
            int a,b;
            cin>>a>>b;
            v.push(b);
        }
        int res = 0;
        int size = v.size();
        tak = min(size,tak);
        while(tak--)
        {
            res +=v.top();
            v.pop();
        }
        cout<<res<<endl;
    }

return 0;
}