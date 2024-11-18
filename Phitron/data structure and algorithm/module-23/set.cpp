#include<bits/stdc++.h>
using namespace std;

int main(){

    // decleare
    set<int>s={234}; 

    // insertion
    s.insert(1234);

    // print
    for(auto it = s.begin(); it !=s.end(); it++)
    {
        cout<<*it<<" ";
    }

    // search a element.
    if(s.count(10)) cout<<"YES"<<endl; // return type bool.
    else cout<<"NO"<<endl;
    
    auto it = s.find(100); // return type iterator.
    if(it != s.end())
    {
        cout<<"found"<<endl;
    }
    else cout<<"found"<<endl;


return 0;
}