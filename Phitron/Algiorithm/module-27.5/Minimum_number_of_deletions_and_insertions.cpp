//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
// https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
  public:
    int minOperations(string &a, string &b) {
        // Your code goes here
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
    
    int lcs = dp[n][m];
    return (n-lcs + m-lcs);
    }
};

//{ Driver Code Starts.
int main() {

    int t;
    cin >> t;
    while (t--) {
        string s1, s2;
        cin >> s1 >> s2;

        Solution ob;
        cout << ob.minOperations(s1, s2) << "\n";

        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends