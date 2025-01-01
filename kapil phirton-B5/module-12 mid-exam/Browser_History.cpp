#include<bits/stdc++.h>
using namespace std;

int main(){
    list<string>mylist;
    while(true)
    {
        string s;
        cin>>s;
        if(s=="end") break;
        mylist.push_back(s);
    }
    int x;
    cin>>x;
    auto current = mylist.begin();
    while(x--)
    {
        string com;
        cin>>com;
        if(com=="visit")
        {
            string w_add;
            cin>>w_add;
            auto it =find(mylist.begin(), mylist.end(), w_add);
            if(it!=mylist.end())
            {
                cout<<*it<<endl; // or cout<<w_add<<endl
                current = it;
            }
            else cout<<"Not Available"<<endl;

        }
        else if(com == "next")
        {
            if(next(current,1)==mylist.end()) cout<<"Not Available"<<endl;
            else
            {
                current = next(current,1);
                cout<<*current<<endl;
            }
        }
        else if(com == "prev")
        {
            if(current == mylist.begin()) cout<<"Not Available"<<endl;
            else
            {
                current = prev(current,1);
                cout<<*current<<endl;
            }   
        }
    }    
return 0;
}