//https://leetcode.com/problems/maximum-subarray-with-equal-products/description/
class Solution {
public:
    int maxLength(vector<int>& nums) {
        int n = nums.size();
        int ans = 2;
        for(int i = 0; i<n; i++)
        {
            long long prod = nums[i];
            int g = nums[i]; // GCD
            int l = nums[i]; // LCM
            for(int j = i+1; j<n; j++) // we must have to  start here from (j+1).
            {
                prod *= nums[j];
                g = gcd(g,nums[j]);
                l = lcm(l,nums[j]);
                if(prod != g*l) break;
                ans = max(ans, j-i+1);
            }
        }
            return ans;
    }
};
