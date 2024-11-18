
#include<bits/stdc++.h>
using namespace std;
vector<vector<int>>grap;
vector<bool>visited;
vector<int>level;
vector<int>near_shop;

void dfs(vector<vector<int>>grap, int u, int my_l)
{
    queue<int>q;
    q.push(u);
    visited[u]= true; // here vertices started from 0. so don't -1.
    while(!q.empty())
    {
        int v = q.front();
        q.pop();
        if(level[v]==my_l) near_shop.push_back(v);
        for(int x : grap[v])
        {
            if(visited[x]) continue;
            q.push(x);
            visited[x]= true;
            level[x] = level[v]+1;
        }
    }
}

int main(){

    int n,m;
    cin>>n>>m;
    grap.resize(100001);
    visited.resize(100001,false);
    level.resize(100001,0);
    for(int i= 0; i<m; i++)
    {
        int u,v;
        cin>>u>>v;
        grap[u].push_back(v);
        grap[v].push_back(u);
    }

    //output
    int q;
    cin>>q;

    dfs(grap,0,q);  
    sort(near_shop.begin(), near_shop.end());
    for(int x : near_shop)
    {
        cout<<x<<" ";
    }
    if(near_shop.empty()) cout<<"-1";

return 0;
}