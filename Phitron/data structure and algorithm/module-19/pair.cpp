#include<bits/stdc++.h>
using namespace std;

int main(){

    // decleare pair
    pair<int,bool>pr;

    // create pair
    pr = {10,true}; //2nd way
    pr = make_pair(10,false); // fast way

    //access pair
    cout<<pr.first<<" "<<pr.second;

return 0;
}