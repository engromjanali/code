#include<bits/stdc++.h>
using namespace std;
int main(){

    int N;
    cin>>N;
    vector<int>V(N);
    for(int i=0; i<N; i++)
    {
        cin>>V[i];
    }
    for(auto i = V.begin(); i<V.end(); i++)
    {
        if(*i >0)
        {
            *i = 1;
        }
        else if(*i <0)
        {
            *i = 2;
        }
    }
    for(int x : V)
    {
        cout<<x<<" ";
    }

return 0;
}