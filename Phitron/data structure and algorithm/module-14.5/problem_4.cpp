#include<bits/stdc++.h>
using namespace std;

int main(){

    int a ;
    cin>>a;
    queue<int>q;
    while(a--)
    {
        int x;
        cin>>x;
        q.push(x);
    }
    stack<int>st;
    while(!q.empty())
    {
        st.push(q.front());
        q.pop();
    }
    while(!st.empty())
    {
        q.push(st.top());
        st.pop();
    }
    while(!q.empty())
    {
        cout<<q.front()<<" ";
        q.pop();
    }

return 0;
}