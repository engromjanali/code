#include<bits/stdc++.h>
using namespace std;

int main(){
    int a;
    cin>>a;
    stack<int>st1, st2;
    while(a--)
    {
        int x ;
        cin>>x;
        st1.push(x);
    }
    cin>>a;
    while(a--)
    {
        int x;
        cin>>x;
        st2.push(x);
    }
    if(st1.size() != st2.size()) cout<<"NO"<<endl;
    else
    {
        bool flag = true;
        while(!st1.empty())
        {
            if(st1.top()!=st2.top()) 
            {
                cout<<"NO"<<endl;
                flag = false;
                break;
            }
            st1.pop();
            st2.pop();
        }
        if(flag) cout<<"YES";
    }

return 0;
}