#include<bits/stdc++.h>
using namespace std;

vector<bool>visited;
vector<int>height;

int dfs(vector<vector<int>>&grap, int u)
{
    int res = 0;
    visited[u-1] = true;

    for(int x : grap[u-1])
    {
        if(visited[x-1]) continue;
        int hi =dfs(grap, x);
        height[u-1] =max(height[u-1] ,height[x-1]+1);
        res = max(res, hi+1);
    } 
    return res;
}

int main(){

    int n,m;
    cin>>n>>m;
    vector<vector<int>>grap(n);
    visited.resize(n, false);
    height.resize(n,0);
    while(m--)
    {
        int u,v;
        cin>>u>>v;

        grap[u-1].push_back(v);
        grap[v-1].push_back(u);
    }

    //output
    int q;
    cin>>q;
    int res = dfs(grap,1);
    cout<<"max height = "<<res<<"\n"<<"height of "<<q<<" = "<<height[q-1];

return 0;
}