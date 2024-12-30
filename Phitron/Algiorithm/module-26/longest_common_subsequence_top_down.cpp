
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
            dp[i][j] = -1;
        }
    }
    cout<<top_down(a,n,b,m)<<endl;

return 0;
}