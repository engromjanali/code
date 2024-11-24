// https://leetcode.com/problems/max-area-of-island/
class Solution {
public:
    typedef pair<int,int> pir;
    vector<vector<bool>>visited;
    vector<pir>path = {{1,0},{-1,0},{0,1},{0,-1}};
    bool isValid(vector<vector<int>>grid ,pir p)
    {
        return (p.first<grid.size() && p.first>=0 && p.second>=0 && p.second<grid[0].size());
    }
    int dfs(vector<vector<int>>& grid , pir s)
    {
        int res =0;
        visited[s.first][s.second]=true;
        for(pir x : path)
        {
            pir v = {x.first+s.first , x.second+s.second};
            if(!isValid(grid,v) || visited[v.first][v.second] || grid[v.first][v.second] == 0) continue;
            res +=dfs(grid,v);
        }
        res++;
        return res;;
    }
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        visited.resize(grid.size(),vector<bool>(grid[0].size(),false));
        int res = 0;
        for(int i=0; i<grid.size(); i++)
        {
            for(int j=0; j<grid[0].size(); j++)
            {
                if(visited[i][j] || grid[i][j]==0) continue;
                    res = max(res,dfs(grid,{i,j}));
            }
        }
        return res;
    }
};