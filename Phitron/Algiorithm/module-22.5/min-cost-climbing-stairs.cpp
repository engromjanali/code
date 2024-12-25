
//https://leetcode.com/problems/min-cost-climbing-stairs/
// buttom up - ----------------------------------
class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        vector<int>cost2(cost);
        cost2.push_back(0);
        vector<int>new_arr(cost2.size(),0);
        new_arr[0] = cost2[0];
        new_arr[1] = cost2[1];
        for(int i =2; i <cost2.size(); i++)
        {
            new_arr[i] = min(new_arr[i-1]+cost2[i] , new_arr[i-2]+cost2[i]);
        }
        return new_arr[cost2.size()-1];
    }
};


//https://leetcode.com/problems/min-cost-climbing-stairs/
// top down --------------------------------------------
class Solution {
public:
vector<int>dp;
int top_down(vector<int>cost, int n)
{
    if(n<0) return 0;
    if(dp[n] != -1) return dp[n];
    int a = top_down(cost, n-1) + cost[n];
    int b = top_down(cost, n-2) + cost[n];
    return dp[n] = min(a,b);
}
    int minCostClimbingStairs(vector<int>& COST) {
        dp.clear();
        dp.shrink_to_fit();
        vector<int>cost(COST);
        cost.push_back(0);
        dp.resize(cost.size(), -1);
        return top_down(cost, cost.size()-1);
    }
};