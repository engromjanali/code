#include<bits/stdc++.h>
using namespace std;
void fun(int * A, vector<int> & V,int N )// pass by reference. vector reference.
{
    if(N == 0) return;
    fun(A,V,N-1);
    V.push_back(A[N-1]);
    // cout<<N-1;
}

int main(){


    int N;
    cin>>N;
    vector<int>V;
    int A[N];
    int B[N];

    for(int i=0; i<N; i++)
    {
        cin>>A[i];
    }
    for(int i=0; i<N; i++)
    {
        cin>>B[i];
    }
    fun(B,V,N);
    fun(A,V,N);
    // cout<<V.size();
    for(int X : V){
        cout<<X<<" ";
    }

return 0;
}