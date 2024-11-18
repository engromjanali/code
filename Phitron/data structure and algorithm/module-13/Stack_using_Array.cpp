#include<bits/stdc++.h>
using namespace std;
class myStack
{
    public :
        vector<int>v;
        void push(int val)
        {
            v.push_back(val);
        }
        void pop()
        {
            v.pop_back();
        }
        int top()
        {
            return v.back();
        }
        bool empty()
        {
            return v.empty();
        }
        int size()
        {
            return v.size();
        }
};
int main(){
    myStack mystack;
    int a;
    cin>>a;
    while(a--)
    {
        int x;
        cin>>x;
        mystack.push(x);
    }
    while(!mystack.empty())
    {
        cout<<mystack.top()<<endl;
        mystack.pop();
    }
    
    if(!mystack.empty())
    {
        cout<<mystack.top()<<endl;
        mystack.pop();
    }
return 0;
}