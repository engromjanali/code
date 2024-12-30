// https://leetcode.com/problems/coin-change/
class Solution {
public:
    vector<vector<int>>dp;
    int coin(vector<int>&arr, int n , int s){
        if(n==0)
        {
            if(s==0) return 0;
            else return INT_MAX-1;
        }
        if(dp[n][s] != -1) return dp[n][s];
        if(arr[n-1] <= s){
            int a = coin(arr,n,s-arr[n-1]) +1;
            int b = coin(arr,n-1,s);
            return dp[n][s] = min(a,b);
        }
        else{
            return dp[n][s] = coin(arr,n-1,s);
        }
    }
    int coinChange(vector<int>& coins, int amount) {
        dp.clear();
        dp.shrink_to_fit();
        dp.resize(coins.size()+1, vector<int>(amount+1));
        for(int i =0; i<=coins.size(); i++)
        {
            for(int j =0; j<=amount; j++){
                dp[i][j] = -1;
            }
        }
        int res = coin(coins, coins.size(), amount);
        if(res >= INT_MAX-1){
            return -1;
        }
        return res;
    }
};
