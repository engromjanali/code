#include<bits/stdc++.h>
using namespace std;
int main(){

    list<int>mylist(10);

    //size function return current size.
    cout<<mylist.size()<<endl;

    //max_size function return maximum size of allocation.
    cout<<mylist.max_size()<<endl;

    // clear : the list will be clear and and size will be zero.
    mylist.clear();

    // it's return true or false as (0/1) for empty list return 1 otherwise 0.
    cout << mylist.empty() << endl;

    // resize : resize the list and new value will be zero. for  the folowing (S,V) function new every value will be 'V'.
    mylist.resize(20);
    mylist.resize(20,5);

    //just check front value and back value what.
    cout<<mylist.front();
    cout<<mylist.back();
    

return 0;
}