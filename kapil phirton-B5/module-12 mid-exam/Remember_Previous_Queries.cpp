#include<bits/stdc++.h>
using namespace std;

void print(list<int>list)
{
    cout<<"L -> ";
    for(auto i = list.begin(); i!=list.end(); i++)
    {
        cout<<*i<<" ";
    }
    cout<<endl;

    list.reverse();
    cout<<"R -> ";
    for(auto i = list.begin(); i!=list.end(); i++)
    {
        cout<<*i<<" ";
    }
    cout<<endl;
    
    // cout<<"R -> ";
    // for(auto i = prev(list.end(),1); i!=prev(list.begin(),1); i = prev(i,1))
    // {
    //     cout<<*i<<" ";
    // }
    // cout<<endl;
}

int main(){

    list<int>list;
    int q; cin>>q;
    while (q--)
    {
        int op, p;
        cin>>op>>p;
        if(op==0)
        {
            list.push_front(p);
            print(list);
        }
        else if(op==1) {
            list.push_back(p);
            print(list);
        }
        else{
            if(list.size()-1>=p)
            {
                list.erase(next(list.begin(),p));
            }
            print(list);
        }
    }
    

return 0;
}