#include<bits/stdc++.h>
using namespace std;

int main(){
    int e;
    cin>>e;
    stack<int>st1;
    while(e--)
    {
        int x ;
        cin>>x;
        st1.push(x);
    }

    stack<int>a;
    while(!st1.empty())
    {
        a.push(st1.top());
        st1.pop();
    }
    st1=a;

    while(!st1.empty())
    {
            cout<<st1.top()<<" ";
            st1.pop();
    }
return 0;
}