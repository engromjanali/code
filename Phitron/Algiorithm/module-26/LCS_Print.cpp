#include<bits/stdc++.h>
using namespace std;
int dp[1004][1005];
int top_down(string a , int n, string b, int m){
    // cout<<"df";
    if(n==0 || m ==0)
        return 0;
    if(dp[n][m] != -1)
        return dp[n][m];

    if(a[n-1] == b[m-1]){
        return dp[n][m] = top_down(a,n-1,b,m-1)+1;
    }
    else{
        return dp[n][m] = max(top_down(a,n-1,b,m) , top_down(a,n,b,m-1));
    }

}
int main(){

    string a,b;
    cin>>a>>b;
    int n = a.size();
    int m = b.size();
    for(int i =0; i<=n; i++)
    {
        for(int j =0; j<=m; j++){
            if(i==0 || j ==0) dp[i][j] = 0;
        }
    }
    for(int i =1; i<=n; i++)
    {
        for(int j =1; j<=m; j++){
            if(a[i-1] == b [ j-1]){
                dp[i][j] = dp[i-1][j-1]+1;
            }
            else{
                dp[i][j] = max(dp[i-1][j] , dp[i][j-1]);
            }
        }
    }
    string res="";
    int p = n, q = m;
    while(p != 0 && q != 0){
        if(a[p-1] == b[q-1])
        {
            res+=a[p-1];
            p--;
            q--;
        }
        else{
            if(dp[p-1][q] > dp[p][q-1]){
                p--;
            }
            else q--;
        }
    }
    
    cout<<dp[n][m]<<endl;
    reverse(res.begin(), res.end());
    cout<<res<<endl;
return 0;
}

