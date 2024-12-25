#include<bits/stdc++.h>
using namespace std;

int main(){

    int n; cin>>n;
    int arr[n];
    for(int i =0; i<n; i++){
        cin>>arr[i];
    }
    int s;
    cin>>s;
    bool dp[n+1][s+1];
    dp[0][0] = true;
    for(int i =1; i<=s; i++)
    {   
        dp[0][i] = false;        
    }
    for(int i=1; i<=n; i++)
    {
        for(int j =0; j<=s; j++)
        {
            if(arr[i-1]<=j)
            {
                bool a = dp[i-1][j-arr[i-1]];
                bool b = dp[i-1][j];
                dp[i][j] = a||b;
            }
            else{
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    for(int i=0; i<=n; i++)
    {
        for(int j =0; j<=s; j++)
        {
            cout<<dp[i][j]<<" ";
        }
        cout<<endl;
    }
    if(dp[n][s]) cout<<"YES"<<endl;
    else cout<<"NO"<<endl;
return 0;
}