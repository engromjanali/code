#include<bits/stdc++.h>
using namespace std;
int main(){

    // fast way.
    // for this fondition we have to use push_back() function because initial state the vector dose not have any size. 
    // one more thing the vector capacity will be double if the vector size is over. it's valid only for push_back() function.
    vector<int > V;
    int N=10;
    for(int i=0; i<N; i++){
        int x;
        cin>>x;
        V.push_back(x);  
    }
    
    // 2nd way.  if the vector size has over the vector size won't be increase.

    vector<int>V(N);
    for(int i =0; i<N; i++){
        cin>>V[i];
    }

    return 0;
}