// int array insert in vector
#include<bits/stdc++.h>
using namespace std;
int main(){

    int N;
    cin>>N;
    vector<int> A(N);
    for(int i=0; i<N;i++)
    {
        cin>>A[i];
    }

    int M;
    cin>>M;
    int B[M];
    for(int i=0; i<M;i++)
    {
        cin>>B[i];
    }

    int X; 
    cin>>X;
    A.resize(M+N);
    int B_size = sizeof(B)/sizeof(B[0]);
    A.insert(A.begin()+X,B ,B+B_size);

    for(int i=0; i<M+N; i++)
    {
        cout<<A[i]<<" ";
    }
return 0;
}