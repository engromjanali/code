#include<bits/stdc++.h>
using namespace std;

class myQueue
{
    public :
        list<int>v;

        void push(int val)
        {
            v.push_back(val);
        }
        void pop()
        {
            v.pop_front();
        }
        int front()
        {
            return v.front();
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
    myQueue qu;
    int a;
    cin>>a;
    while(a--)
    {
        int x;
        cin>>x;
        qu.push(x);
    }
    while(!qu.empty())
    {
        cout<<qu.front()<<endl;
        qu.pop();
    }
    
    if(!qu.empty())
    {
        qu.pop();
        cout<<"hii";
    }
return 0;
}