//  s1 + s2 = s
//  s1 - s2 = t
//  ---------------
//  2(s1) = s+t
//  s1 = (s+t)/2  // if we can make s1 that's mean ans is true. the question is want ans cout so we should return how many time we can make 's1'.

// 2nd way.
// (s-t)/2 = s1

//https://leetcode.com/problems/target-sum/

#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int findTargetSumWays(vector<int>& arr, int x) {
        // Your code goes here
        int n = arr.size();
        int sum =0;
        for(int i =0; i<arr.size(); i++)
        {
          sum +=arr[i];
        } 
        if((sum+x)%2 != 0) return 0;
        int target = (sum+x)/2;
        if(target<0) return 0;
        int dp[n+1][target+1];
        for(int i =0; i<=target; i++)
        {
            dp[0][i] = 0;
        }
        dp[0][0] = 1;

	    for(int i =1; i<=n; i++)
        {
            for(int j =0; j<=target; j++)
            {
                if(arr[i-1] <= j){
	    			int a = dp[i-1][j-arr[i-1]];
	    			int b = dp[i-1][j];
	    			dp[i][j] = (a+b);
	    		}
	    		else{
	    			dp[i][j] = dp[i-1][j];
	    		}
            }
        }
        return dp[n][target];   
    }
};


// 2nd way --------------

//https://leetcode.com/problems/target-sum/
class Solution {
public:
    int findTargetSumWays(vector<int>& arr, int x) {
        // Your code goes here
        int n = arr.size();
        int sum =0;
        for(int i =0; i<arr.size(); i++)
        {
          sum +=arr[i];
        } 
        if((sum-x)%2 != 0) return 0;
        int target = (sum-x)/2;
        if(target<0) return 0;
        int dp[n+1][target+1];
        for(int i =0; i<=target; i++)
        {
            dp[0][i] = 0;
        }
        dp[0][0] = 1;

	    for(int i =1; i<=n; i++)
        {
            for(int j =0; j<=target; j++)
            {
                if(arr[i-1] <= j){
	    			int a = dp[i-1][j-arr[i-1]];
	    			int b = dp[i-1][j];
	    			dp[i][j] = (a+b);
	    		}
	    		else{
	    			dp[i][j] = dp[i-1][j];
	    		}
            }
        }
        return dp[n][target];   
    }
};