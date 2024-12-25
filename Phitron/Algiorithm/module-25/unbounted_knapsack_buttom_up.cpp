#include<bits/stdc++.h>
using namespace std;
int dp[10000][10000];
int main(){

    int n,s;
    cin>>n>>s;    
    int value[n];
    int weight[n];
    for (int i =0; i<n; i++)
    {
        cin>>value[i];
    }
    for (int i =0; i<n; i++)
    {
        cin>>weight[i];
    }
    
    for(int i =0; i<=n; i++)
    {
        for(int j=0; j<=s; j++)
        {
            // if(i==0 || j == 0) // hay romjan if you feal any problem uncomment it. and comment next this line. and make j =1 in main loop(39 line).
            if(i==0)
                dp[i][j] =0;
        }
    }
    for(int i =0; i<=n; i++)
    {
        for(int j=0; j<=s; j++)
        {
                cout<<dp[i][j]<<" ";
        }
        cout<<endl;
    }
    
    for(int i =1; i<=n; i++)
    {
        for(int j =0; j<= s; j++)
        {
            if(j>=weight[i-1])
            {
                int op1 = (dp[i][j-weight[i-1]])+ value[i-1];
                int op2 = (dp[i-1][j]);
                dp[i][j] = max(op1, op2);
            }
            else {
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    
    for(int i =0; i<=n; i++)
    {
        for(int j=0; j<=s; j++)
        {
                cout<<dp[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<dp[n][s]<<endl;
return 0;
}