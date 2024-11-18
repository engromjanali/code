#include<bits/stdc++.h>
using namespace std;

vector<bool>visited;
vector<int>depth;

int dfs(vector<vector<int>>&grap, int u)
{
    int res = 0;
    visited[u-1] = true;

    for(int x : grap[u-1])
    {
        if(visited[x-1]) continue;
        depth[x-1] =depth[u-1]+1;
        int dep =dfs(grap, x);
        res = max(res, dep+1);
    } 
    return res;
}

int main(){

    int n,m;
    cin>>n>>m;
    vector<vector<int>>grap(n);
    visited.resize(n, false);
    depth.resize(n,0);
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
    cout<<"max depth = "<<res<<"\n"<<"depth of "<<q<<" = "<<depth[q-1];

return 0;
}