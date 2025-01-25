// https://leetcode.com/problems/zigzag-grid-traversal-with-skip/solutions/
class Solution {
public:
    vector<int> zigzagTraversal(vector<vector<int>>& grid) {
        vector<int>v;
        bool flag = true;
        for(int i =0; i<grid.size(); i++){
            if(flag){
                for(int j =0; j<grid[0].size(); j++)
                {
                    if(j %2==0) v.push_back(grid[i][j]);
                }
                flag = 1-flag;
            }
            else{
                for(int j =grid[0].size()-1; j>=0; j--)
                {
                    if(j %2==1) v.push_back(grid[i][j]);
                }
                flag = 1-flag;
            }
        }
        return v;
    }
};