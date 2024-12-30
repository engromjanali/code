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
        
        for(int j =0; j<=m; j++)
        {
            dp[0][j] = INT_MAX-1;
        }
        dp[0][0]=0;
        for(int i =1; i<=n; i++)
        {
            for(int j =0; j<=m; j++)
            {
                if(j>=arr[i-1])
                {
                    int op1 = (dp[i][j-arr[i-1]])+1;
                    int op2 = (dp[i-1][j]);
                    dp[i][j] = min(op1 , op2);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        // for(int i =0; i<=n; i++)
        // {
        //     for(int j =0; j<=m; j++)
        //     {
        //         cout<<dp[i][j]<<" ";
        //     }
        //     cout<<endl;
        // }
        if(dp[n][m]>=INT_MAX-1){
            cout<<"-1"<<endl;
        }
        else cout<<dp[n][m]<<endl;
    }
    

return 0;
}