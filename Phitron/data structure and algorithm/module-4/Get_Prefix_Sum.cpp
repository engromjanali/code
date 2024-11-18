#include<bits/stdc++.h>
using namespace std;
int main(){

    int N;
    cin>>N;
    int A[N];
    for(int i=0; i<N; i++)
    {
        cin>>A[i];
    }
    long long int pre[N];
    pre[0]= A[0];
    for(int i=1; i<N; i++)
    {
        pre[i]=pre[i-1]+A[i];
    }
    for(int i=N-1; i>=0; i--)
    {
        cout<<pre[i]<<" ";
    }

return 0;
}