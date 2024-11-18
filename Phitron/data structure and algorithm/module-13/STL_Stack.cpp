#include<bits/stdc++.h>
using namespace std;

int main(){

    stack<int>st;
    int a;
    cin>>a;
    while(a--)
    {
        int x;
        cin>>x;
        st.push(x);
    }
    cout<<st.size()<<endl<<endl;
    while(!st.empty())
    {
        cout<<st.top()<<endl;
        st.pop();
    }

return 0;
}