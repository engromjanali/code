// https://leetcode.com/problems/house-robber/description/
// # top down---------
class Solution {
public:
    vector<int>dp;
    int top_down(vector<int>&arr, int n)
    {
        if(n<0) return 0;
        if(dp[n] != -1) return dp[n];

        int a = top_down(arr,n-1);
        int b = top_down(arr,n-2) + arr[n];
        return dp[n] = max(a,b);
    }
    int rob(vector<int>& nums) {
        dp.clear(); dp.shrink_to_fit();
        int n = nums.size();
        dp.resize(n,-1);
        return top_down(nums,n-1);  
    }
};

// # buttom up ------------------
class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        vector<int>arr(n+1,0);
        for(int i =1; i<=n; i++)
        {
            arr[i] = nums[i-1];
        }
        vector<int>new_arr(n+1);
        new_arr[0]=0; 
        new_arr[1]=arr[1];
        for(int i = 2; i<=n; i++)
        {
            int a = new_arr[i-2]+arr[i];
            int b = new_arr[i-1];
            new_arr[i] = max(a,b);
        }
        return new_arr.back();  
    }
};