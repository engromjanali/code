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
    bool res=false;
    sort(A,A+N);
    for(int i=0; i<N-1; i++)
    {
        if(A[i]==A[i+1]) res = true;
    }
    if(res) cout<<"YES";
    else cout<<"NO";

return 0;
}