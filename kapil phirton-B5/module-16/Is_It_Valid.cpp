#include<bits/stdc++.h>
using namespace std;

int main(){

    int n; cin>>n;
    while(n--)
    {
        stack<char>stk;
        queue<char>q;
        string s ; cin>>s;
        for(int i =0; i<s.size(); i++)
        {
            q.push(s[i]);    
        }
        while(!q.empty()){
            if(stk.empty())
            {
                char a = q.front();
                q.pop();
                stk.push(a);
            }
            else{
                if(q.front()=='1' && stk.top()=='0')
                {
                    q.pop();
                    stk.pop();
                }
                else if(q.front()=='0' && stk.top()=='1')
                {
                    q.pop();
                    stk.pop();
                }
                else{
                    stk.push(q.front());
                    q.pop();
                }
            }
        }
        if(stk.empty()) cout<<"YES"<<endl;
        else cout<<"NO"<<endl;
    }

return 0;
}