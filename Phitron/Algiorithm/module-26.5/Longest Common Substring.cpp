//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

// 06. https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Solution {
  public:
    int longestCommonSubstr(string& a, string& b) {
        // your code here
        int n = a.size();
        int m = b.size();
        int dp[n+1][m+1];
        for(int i =0; i<=n; i++)
        {
            for(int j =0; j<=m; j++)
            {
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }
        
        for(int i =1; i<=n; i++)
        {
            for(int j =1; j<=m; j++)
            {
                if(a[i-1]==b[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        int res = 0;
        for(int i =0; i<=n; i++)
        {
            for(int j =0; j<=m; j++)
            {
                res = max(res, dp[i][j]);
            }
        }
        return res;
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

        cout << ob.longestCommonSubstr(s1, s2) << endl;

        cout << "~"
             << "\n";
    }
}

// } Driver Code Ends