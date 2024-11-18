#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin>>t;
    while (t--)
    {
        int a;
        cin>>a;
        string s;
        cin>>s;
        queue<char>qu;
        for (char x : s)
        {
            qu.push(x);
        }
        stack<char>stk;
        // cout<<"hello"<<qu.size();
        while (!qu.empty())
        {
            if(stk.empty())
            {
                stk.push(qu.front());
                qu.pop();
            }
            else if(stk.top()==qu.front())
            {
                stk.pop();
                qu.pop();
            }
            else if(stk.top()=='R' && qu.front()=='B')
            {
                char temp = 'P';
                stk.pop();
                qu.pop();
                if(stk.empty())stk.push(temp);
                else if(stk.top()==temp) stk.pop();
                else stk.push(temp);
            }
            else if(stk.top()=='R' && qu.front()=='G')
            {
                char temp = 'Y';
                stk.pop();
                qu.pop();
                if(stk.empty())stk.push(temp);
                else if(stk.top()==temp) stk.pop();
                else stk.push(temp);
            }
            else if(stk.top()=='B' && qu.front()=='G')
            {
                char temp = 'C';
                stk.pop();
                qu.pop();
                if(stk.empty())stk.push(temp);
                else if(stk.top()==temp) stk.pop();
                else stk.push(temp);
            }
            else if(stk.top()=='B' && qu.front()=='R')
            {
                char temp = 'P';
                stk.pop();
                qu.pop();
                if(stk.empty())stk.push(temp);
                else if(stk.top()==temp) stk.pop();
                else stk.push(temp);
            }
            else if(stk.top()=='G' && qu.front()=='R')
            {
                char temp = 'Y';
                stk.pop();
                qu.pop();
                if(stk.empty())stk.push(temp);
                else if(stk.top()==temp) stk.pop();
                else stk.push(temp);
            }
            else if(stk.top()=='G' && qu.front()=='B')
            {
                char temp = 'C';
                stk.pop();
                qu.pop();
                if(stk.empty())stk.push(temp);
                else if(stk.top()==temp) stk.pop();
                else stk.push(temp);
            }
            else if(stk.top() !=qu.front()) 
            {
                stk.push(qu.front());
                qu.pop();
            }
        }
        stack<char>stk2;
        while(!stk.empty())
        {
            stk2.push(stk.top());
            stk.pop();
        }
        while(!stk2.empty())
        {
            cout<<stk2.top();
            stk2.pop();
        }
        cout<<endl;
    }
    
return 0;
}