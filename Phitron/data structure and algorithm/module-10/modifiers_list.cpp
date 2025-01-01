#include<bits/stdc++.h>
using namespace std;

int main(){

    list<int>mylist(10);
    list<int>newlist(10);
    vector<int>V={12,13};
    int arr[]={2354,324,252,223};

// assign
    // mylist = newlist;
    // mylist.assign(newlist.begin(), newlist.end());
    
// insert
    // mylist.push_back(43);
    // mylist.push_front(3242);

    // mylist.insert(next(mylist.begin() , 2) , 10900);
    // mylist.insert(next(mylist.begin(),3), newlist.begin(), newlist.end());
    // mylist.insert(next(mylist.begin(),3), {10,1234,3254,54,2523,256,2222});
    // mylist.insert(next(mylist.begin(),3), V.begin(), V.end());
    // mylist.insert(next(mylist.begin(),3), arr, arr+sizeof(arr)/4);


// erase
    // mylist.pop_back();
    // mylist.pop_front();

    // mylist.erase(next(mylist.begin(),4));// 4 mean 4th index will be erase.
    // mylist.erase(mylist.begin(), prev(mylist.end(),2));
    // mylist.remove(40); // every 40 will be delete.
// replace
    replace(mylist.begin(), mylist.end(), 30,100); //30 will be replace by 100
    for(int x : mylist)
    {
        cout<<x<<" ";
    }
// find
    auto it = find(mylist.begin(), mylist.end(), 40);
    if(it==mylist.end())
    {
        cout<<"not found!"<<endl;
    }
    else cout<<"found!"<<endl;
// sort
    mylist.sort(); // for assending
    mylist.sort(greater<int>()); // desanding  
    mylist.sort(cmp);// for descending order
    // inline function
    mylist.sort([](int a, int b){return a>b;});// for descending order
    mylist.reverse();  
    mylist.unique();  
return 0;
}