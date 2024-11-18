#include<bits/stdc++.h>
using namespace std;
int main(){

//everything is like a vector only one thing is nothing. thst is index number. we can access list by index number.
    
    // // create zero size list
    // list<int>mylist;

    // // create N size list
    int N = 10;
    // list<int>mylist(N);

    // // create N size list where every value will be zero.
    // list<int>mylist(N,0);

    // // copy of list2
    // list<int>list2(N);
    // list<int>mylist(list2);

    // initile
    list<int>mylist={10,20,30};

    // // array to list
    // int arr[N]={10,20,30};
    // list<int>mylist(arr, arr+N);
    // cout<<mylist.front()<<" "<<mylist.back();

    // // vector to list
    vector<int>V(N);
    list<int>mylist(V.begin(), V.end());

    //there are two way to access list by loop.
    for(auto it = mylist.begin(); it!=mylist.end(); it++)
    {
        cout<<*it<<" ";
        
    }

    for(int x : mylist)
    {
        cout<<x<<" ";
    }    

return 0;
}