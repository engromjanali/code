#include<bits/stdc++.h>
using namespace std;
int main(){
    list<int>list;
    while (true)
    {
        int n;
        cin>>n;
        if(n==-1) break;
        list.push_back(n);
    }
    list.sort();// for descending order
    list.unique();
    while(!list.empty())
    {
        cout<<list.front()<<" ";
        list.pop_front();
    }
return 0;
}