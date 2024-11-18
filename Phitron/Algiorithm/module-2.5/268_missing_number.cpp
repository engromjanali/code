#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int missingNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        if(nums.front() != 0) return 0;
        int trk = nums.front();
        for(int i=1; i<nums.size(); i++)
        {
            if((nums[i] - trk) > 1) return trk+1;
            if((nums[i] - trk) == 1) trk++;
        }
        return nums.back()+1;
    }
};