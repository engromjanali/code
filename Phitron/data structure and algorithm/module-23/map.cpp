// if we use more and more and more  value for map the map may be can misbehave. (TLE).
// we will use it as last option.
// map dose not follow any order.
// default value 0 (zero).
// data tyoe can be anything.
// it's use hashing process.

// O(log N) for everything.

#include<bits/stdc++.h>
using namespace std;

int main(){

    // decleare
    map<string,int>mp;
    map<int,int>mp1;
    map<float,int>mp2;
    
    // insertion
    mp.insert({"romjan" , 101});
    mp["siam"] = 2342;
    mp["al amin"] ++; //value will be 1.

    mp.insert({"romjan" , 677844}); // fast value won't change.

    // replace/change/assign   
    mp["siam"] = 677652; // the value will be replace.
    
    cout<<mp["siam"]<<endl;

    // chacking value having or not.
    if(mp.count("siam"))
    {
        cout<<"have"<<endl;
    }
    else cout<<"NO"<<endl;

return 0;
}