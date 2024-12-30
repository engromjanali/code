// how many char we should delete to make an palindrom. if we insert those char in oposite site of those character we can make it as palindrom.

#include<bits/stdc++.h>
using namespace std;

int main(){

    string a,b;
    cin>>a;
    b = a;
    reverse(b.begin(),b.end());
    int n,m;
    n = a.size();
    m = b.size();
    int dp[n+1][m+1];
    for(int i =0; i<=n; i++)
        dp[i][0]=0;
    for(int i =0; i<=m; i++)
        dp[0][i]=0;
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
    int lps = dp[n][m];
    cout<<a.size()-lps<<endl;

return 0;
}

