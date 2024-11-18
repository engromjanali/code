#include<bits/stdc++.h>
using namespace std;

void reverseStack(stack<int> &s) {
    if(s.empty()) return;

    int x = s.top();
    s.pop();

    reverseStack(s);
    stack<int>nst;
    while(!s.empty())
    {
        nst.push(s.top());
        cout<<s.top()<<" ";   
        s.pop();
    }
    nst.push(x);
    while(!nst.empty())
    {
        s.push(nst.top());
        // cout<<nst.top()<<" ";
        nst.pop();
    }
    cout<<endl;
}

int main(){
    stack<int>a;
    a.push(3);
    a.push(2);
    a.push(1);
    reverseStack(a);

return 0;
}