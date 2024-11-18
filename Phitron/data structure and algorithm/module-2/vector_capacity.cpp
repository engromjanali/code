#include<bits/stdc++.h>
using namespace std;
int main(){

    vector<int> V;
    V.push_back(5634);
    V.push_back(5634);
    V.push_back(5634);
    V.push_back(5634);
    V.push_back(5634);//one item will be insert in back. and if the insert cross vector limit the vector size will be duble. 
    cout<<V.size(); 
    cout<<V.capacity(); 
    cout<<V.max_size();
    V.clear(); // size will be zero / 0 but the value still will be exist on memery.
    V.resize(100); // resize the vector, for increase vector size new index will be zero by default. 
    V.resize(100,999); // every new value will be the definded value.


return 0;
}