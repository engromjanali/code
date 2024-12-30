//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
int minDeletions(string str, int n);

int main(){
    int t;
    cin >> t;
    while(t--){
        
        int n;
        cin >> n;
        string s;
        cin >> s;
        cout << minDeletions(s, n) << endl;

    
cout << "~" << "\n";
}
return 0;
}
// } Driver Code Ends

// https://www.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

int minDeletions(string a, int n) { 
    //complete the function here 
    string b = a;
    reverse(b.begin(), b.end());
    int m;
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
    int lcs = dp[n][m];
    return (n-lcs);
} 