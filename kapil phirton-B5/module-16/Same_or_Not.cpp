#include<bits/stdc++.h>
using namespace std;

int main(){

    int n; cin>>n;
    int m; cin>>m;
    
    stack<int>stk;
    for(int i =0; i<n; i++){
        int a ; cin>>a;
        stk.push(a);
    }
    
    queue<int>q;
    for(int i =0; i<m; i++){
        int a ; cin>>a;
        q.push(a);
    }
    bool flag = true;
    if(q.size()==stk.size())
    {
        while (!q.empty())
        {
            if(q.front() == stk.top()){
                q.pop();
                stk.pop();
                continue;
            }
            flag = false;
            break;
        }
        
    }
    else flag = false;
    
    if(flag) cout<<"YES"<<endl;
    else cout<<"NO"<<endl;

return 0;
}