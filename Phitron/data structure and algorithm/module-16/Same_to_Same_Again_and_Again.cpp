#include<bits/stdc++.h>
using namespace std;
int main(){

    int a , b;
    cin>>a>>b;
    stack<int> st;
    queue<int>qu;
    while(a--){
        int x;
        cin>>x;
        st.push(x);
    }

    while(b--){
        int x;
        cin>>x;
        qu.push(x);
    }
    
    if(st.size() != qu.size()) cout<<"NO"<<endl;
    else
    {
        bool flag = true;
        while(!qu.empty())
        {
            // cout<<st.top()<<qu.front()<<endl;
            if(st.top() != qu.front()) 
            {
                cout<<"NO"<<endl;
                flag = false;
                break;
            }
            st.pop();
            qu.pop();
        }
        if(flag) cout<<"YES"<<endl;
    }

return 0;
}