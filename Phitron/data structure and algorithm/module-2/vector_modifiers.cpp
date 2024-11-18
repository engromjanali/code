#include<bits/stdc++.h>
using namespace std;
int main(){

    // V.begin()/ V.end() it's return pointer and maximum vector modifiers work with pointers. 

    vector<int> X = {1,2,3};
    vector<int> V = {1,2,3,4};
    // V= X; 
    // V.push_back(34);
    // V.pop_back();
    
    // V.insert(V.begin()+2,101);
    // V.insert(V.begin()+2, X.begin(),X.end());

    // V.erase(V.begin()+2);
    // V.erase(V.begin()+2, V.begin()+4);// for index (2-3).

    // if(v1==v2) cout<<"true"; // compare two vector.

    // // replace is a function of extranal algorithm. not vector function.

    // replace(V.begin(), V.end(), 5, 10); // perfrom the opration in full vector and make 5 to 10.
    // replace(V.begin(), V.end()-2, 5, 10); //perfrom the opration in fast to until last 2nd index.
    // replace(V.begin(), V.begin()+2, 5, 10); //perfrom in fast 2 index.

    // // find is a extranal function what return a pointer / itrator.
    // auto it = find(V.begin(), V.end(), 5);// 5 find in full vector.
    auto it = find(V.begin(), V.begin()+6, 5);// 5 find in fast 6th vector.
    if(it==V.end())// if we did not get any value by it itrator return as garbaze value. or if we get any value itrator return the value. that's why we need to use if-else condition for it.
    {
        cout<<*it;
    }
    else{
        cout<<"Not Found";
    }

return 0;
}