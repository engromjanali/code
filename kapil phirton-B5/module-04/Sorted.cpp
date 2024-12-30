#include<bits/stdc++.h>
using namespace std;
int main(){

    int t;
    cin>>t;
    while(t--)
    {
        int S;
        cin>>S;
        int A[S];

        for(int i=0; i<S; i++)
        {
            cin>>A[i];
        }
        
        bool ans = true;
        
        for(int i=0; i<S-1; i++)
        {
            if(A[i]<=A[i+1]){

            }
            else ans = false;
        }
        if(ans) 
            cout<<"YES"<<endl;
        else 
            cout<<"NO"<<endl;
    }
    return 0;
}
