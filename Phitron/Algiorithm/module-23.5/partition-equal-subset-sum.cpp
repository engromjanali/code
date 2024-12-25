//https://leetcode.com/problems/partition-equal-subset-sum/description/
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int dp[201][20001];
    bool top_down(vector<int>&arr, int s, int n){
        if(n==0){
            if(s==0)
            return true;
            else return false;
        }
        if(dp[n][s] != -1) return dp[n][s];
        if(arr[n-1]<=s){
            bool a = top_down(arr,s-arr[n-1],n-1);
            bool b = top_down(arr,s,n-1);
            return dp[n][s] = a||b;
        }
        else{
            return dp[n][s] = top_down(arr,s,n-1);
        }
    }
    bool canPartition(vector<int>& nums) {
    int sum =0; 
    for(int i =0; i<nums.size(); i++)
    {
       sum +=nums[i];
    }   

    if(sum%2!=0)
       return false;
    for(int i =0; i<=nums.size(); i++)
    {
        for(int j =0; j<=sum/2; j++)
        {
            dp[i][j] = -1;
        }
    }
    return top_down(nums,sum/2,nums.size());
    }
};