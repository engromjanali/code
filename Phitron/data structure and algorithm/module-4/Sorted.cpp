#include<bits/stdc++.h>
using namespace std;
int main(){

    int N;
    cin>>N;
    while(N--)
    {
        int S;
        cin>>S;
        int A[S];

        for(int i=0; i<S; i++)
        {
            cin>>A[i];
        }
        bool res = true;
        for(int i=0; i<S-1; i++)
        {
            if(A[i]<=A[i+1]){

            }
            else res = false;
        }
        if(res) cout<<"YES"<<endl;
        else cout<<"NO"<<endl;
    }
    return 0;
}
