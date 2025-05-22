// https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/description/
class Solution {
public:
    
    long long dp[501][501][3];
    
    long long ans(int i,int j,int k,vector<vector<int>>& a)
    {
        if(i==a.size()-1 && j==a[0].size()-1)
        {
            if(a[i][j]<0 && k<2)
            {
                return 0;
            }
            return a[i][j];
        }
        
        if(i==a.size() || j==a[0].size())
        {
            return -1e9;
        }
        
        if(dp[i][j][k]!=-1)
        {
            return dp[i][j][k];
        }
        
        long long res=a[i][j]+max(ans(i+1,j,k,a),ans(i,j+1,k,a));
        
        if(a[i][j]<0 && k<2)
        {
            res=max(res,max(ans(i+1,j,k+1,a),ans(i,j+1,k+1,a)));
        }
        
        return dp[i][j][k] = res;
    }
    long long maximumAmount(vector<vector<int>>& coins) {
        
        memset(dp,-1,sizeof(dp));
        return ans(0,0,0,coins);
    }
};