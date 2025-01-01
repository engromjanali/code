#include<bits/stdc++.h>
using namespace std;

void xxx(list<string> a)// pass by value. if we change somthing here main "mylist" won't change.
{
    a.front()="hello";
    for(auto x : a)
    {
        cout<<x<<endl;
    }
}
int main(){

    list<string>mylist={"romjan", "kapil", "siam"};

    for(auto x : mylist)
    {
        x = "ka";
        cout<<x<<endl;
    }
    
return 0;
}