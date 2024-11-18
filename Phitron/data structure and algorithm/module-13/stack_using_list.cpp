#include<bits/stdc++.h>
using namespace std;
class myStack
{
    public :
        list<int>l; // implement stack using list.
        void push(int val)
        {
            l.push_back(val);
        }
        void pop()
        {
            l.pop_back();
        }
        int top()
        {
            return l.back();
        }
        bool empty()
        {
            return l.empty();
        }
        int size()
        {
            return l.size();
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