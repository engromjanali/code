// https://leetcode.com/problems/longest-common-subsequence/description/
class Solution {
public:
    int dp[1001][1001];
    int lcs(string &a, string &b, int n, int m)
    {
        if(n==0 || m==0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        if(a[n-1] == b[m-1])
        {
            return dp[n][m]= lcs(a,b,n-1,m-1)+1;
        }
        else{
            int A = lcs(a,b,n-1,m);
            int B = lcs(a,b,n,m-1);
            return dp[n][m] = max(A,B);
        }
    }
    int longestCommonSubsequence(string text1, string text2) {
        int n = text1.size();
        int m = text2.size();
        for(int i =0; i<=n; i++)
        {
            for(int j =0; j<=m; j++)
            {
                dp[i][j] = -1;
            }
        }
        return lcs(text1, text2,n,m);
    }
};