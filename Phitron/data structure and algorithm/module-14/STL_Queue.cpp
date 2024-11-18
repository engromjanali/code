#include<bits/stdc++.h>
using namespace std;

int main(){

    queue<int>qu;

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