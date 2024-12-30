#include<bits/stdc++.h>
using namespace std;

int main(){

    int t; cin>>t;
    while (t--)
    {
        int n,m,s;
        cin>>n>>s;
        m=1000-s;
        int arr[n];
        for(int i =0; i<n; i++)
        {
            cin>>arr[i];
        }
        int dp[n+1][m+1];
        for(int i =0; i<=n; i++)
        {
            for(int j =0; j<=m; j++)
            {
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }
        for(int i =1; i<=n; i++)
        {
            for(int j =1; j<=m; j++)
            {
                if(arr[i-1]<=j){
                    dp[i][j] = max(dp[i][j-arr[i-1]]+arr[i-1] , dp[i-1][j]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        if(dp[n][m]==m)
            cout<<"YES"<<endl;
        else
            cout<<"NO"<<endl;
    }
    

return 0;
}