    // syntex:
    // vector<data_type>vector_name;
    // vector < data_type > vector_name(argument);


#include<bits/stdc++.h>
using namespace std;
int main(){
    int N;
    cin>>N;
    int arr[]={1,2,3,4,5};
    vector<int>V;// it's create a vector with zero size.
    vector<int>V(N);// it's create a vector with N size.and every value will be the garbaze value
    vector<int>V(N, 0);// it's create a vector with N size. and every value will be the definded(0) value. 
    vector<int>V2(V);// it's create a new V2 vector same of V vector
    vector<int>V(arr, arr+5);// it's create a new vector same of the definded array.

    cout<<V.size();

return 0;
}