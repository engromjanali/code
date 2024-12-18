#include<bits/stdc++.h>
using namespace std;

class Solution {
  public:
    // Function to return max value that can be put in knapsack of capacity.
    int knapSack(int capacity, vector<int> &val, vector<int> &wt) {
        // code here
        int dp[10000][10000];
        // int n=val.size(),s= capacity;
        
        // for(int i =0; i<=n; i++)
        // {
        //     for(int j=0; j<=s; j++)
        //     {
        //         if(i==0 || j==0)
        //             dp[i][j] =0;
        //     }
        // }
        
        // for(int i =1; i<=n; i++)
        // {
    
        //     for(int j =1; j<= s; j++)
        //     {
        //         if(j>=wt[i-1])
        //         {
        //             int op1 = (dp[i-1][j-wt[i-1]])+ val[i-1];
        //             int op2 = (dp[i-1][j]);
        //             dp[i][j] = max(op1, op2);
        //         }
        //         else {
        //             dp[i][j] = dp[i-1][j];
        //         }
        //     }
        // }
        // return dp[1][1];
        dp[0][0] = 100;
        int res = dp[0][0];
        return res;
    }
};