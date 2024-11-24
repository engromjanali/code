// https://leetcode.com/problems/flood-fill/
class Solution {
public:

    typedef pair<int,int> pir;
    vector<vector<bool>>visited;
    vector<pir>path = {{1,0},{-1,0},{0,1},{0,-1}};
    bool isValid(vector<vector<int>>grid ,pir p)
    {
        return (p.first<grid.size() && p.first>=0 && p.second>=0 && p.second<grid[0].size());
    }

    void dfs(vector<vector<int>>&image, int sr, int sc, int s_color ,int color){
        visited[sr][sc] = true;
        image[sr][sc] = color;
        for(pir x : path){
            pir v = {x.first+sr , x.second+sc};

            if(!isValid(image , v) || visited[v.first][v.second] || image[v.first][v.second] != s_color) continue;
            dfs(image,v.first,v.second, s_color, color);
        }
    }

    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        visited.resize(image.size(), vector<bool>(image[0].size() , false));
        dfs(image,sr,sc,image[sr][sc] , color);
        return image;
    }
};