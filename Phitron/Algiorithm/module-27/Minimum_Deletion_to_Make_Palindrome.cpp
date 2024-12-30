
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
    string lps;
    int i = n, j = m;
    while(i!=0 && j!=0){
        if(a[i-1]==b[j-1]){
            lps+=a[i-1];
            i--;
            j--;
        }
        else{
            if(dp[i-1][j] > dp[i][j-1]) i--;
            else j--;
        }
    }
    
    reverse(lps.begin(),lps.end());
    cout<<a.size()-lps.size()<<endl;
    cout<<lps<<endl;

return 0;
}

