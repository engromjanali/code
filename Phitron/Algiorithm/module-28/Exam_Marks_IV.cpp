#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;cin>>t;
    while(t--)
    {
        int n,m;
        cin>>n>>m;
        int s = 1000-m;
        long long arr[n];
        for(int i =0; i<n; i++){
            cin>>arr[i];
        }
        long long dp[n+1][s+1];
        for(int j =0; j<=s; j++){
            dp[0][j] = 0;
        }
        dp[0][0] = 1;
        for(int i =1; i<=n; i++)
        {
            for(int j =0; j<=s; j++)
            {
                if(j>=arr[i-1])
                {
                    long long op1 = dp[i][j-arr[i-1]];
                    long long op2 = dp[i-1][j];
                    dp[i][j] = (op1+op2);
                    if(dp[i][j]>1000000007) 
                        dp[i][j] = dp[i][j]%1000000007;
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        cout<<dp[n][s]<<endl;
    }

return 0;
}