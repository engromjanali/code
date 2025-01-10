// https://leetcode.com/problems/count-ways-to-build-good-strings/submissions/1498660740/
class Solution {
public:
    int countGoodStrings(int low, int high, int zero, int one) {

        int dp[high+1];
        for(int i =0; i<=high; i++)
            dp[i] = 0;
        dp[0] = 1;
        for(int i =1; i<=high; i++)
        {
            if(zero <= i){
                dp[i] += dp[i-zero];
            }
            if(one <= i){
                dp[i] += dp[i-one];
            }
            dp[i] = dp[i]%1000000007;
        }
        int res = 0;
        for(int i = low; i<=high; i++)
        {
            res+=dp[i];
            res = res%1000000007;
        }
        return res;
    }
};