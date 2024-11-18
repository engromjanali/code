#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int res =0;
        for(vector<int> it1 : grid)
        {
            for(int it : it1)
            {
                if(it<0) res++;
            }
        }
        return res;
    }
};