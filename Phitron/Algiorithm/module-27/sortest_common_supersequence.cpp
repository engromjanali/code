// supersequence mean A is subsequence of res, and B is subsequence of res also. 
// longest common supersequence mean the addition of the two array.
// A = romjan, B = rohim ;
// res = A+B;
// res = rohimjan; // here lcs=3(rom). so ans= n+m-lcs. // because we can remove only the "lcs" char.


#include<bits/stdc++.h>
using namespace std;

int main(){

    string a,b;
    cin>>a>>b;
    int n,m;
    n = a.size();
    m = b.size();
    int dp[n+1][m+1];
    for(int i =0; i<=n; i++){
        for(int j =0; j<=m; j++){
            if(i==0 || j ==0) dp[i][j] = 0;
        }
    }
    for(int i =1; i<=n; i++)
    {
        for(int j =1; j<=m; j++)
        {
            if(a[i-1]==b[j-1]){
                dp[i][j] = dp[i-1][j-1] +1;
            }
            else{
                dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
            }
        }
    }
    
    int ans = n+m-dp[n][m];
    cout<<ans;


return 0;
}