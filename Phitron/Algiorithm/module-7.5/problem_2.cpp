
#include<bits/stdc++.h>
using namespace std;

vector<vector<int>>grap;
vector<bool>visited;
vector<int>level;
int max_level = 0;

int bfs(vector<vector<int>>&grap, int u, int prent)
{
    queue<int>q;
    q.push(u);
    visited[u-1] = true;

    while ((!q.empty()))
    {
        int v = q.front();
        q.pop();
        
        for(int x : grap[v-1])
        {
            if(visited[x-1]) continue;
            q.push(x);
            visited[x-1] = true;
            level[x-1] = level[v-1]+1;
        }
    }
}

int main(){

    int n,m;
    cin>>n>>m;

    grap.resize(n);
    visited.resize(n,false);
    level.resize(n,0);

    for(int i = 0; i<m; i++)
    {
        int u,v;
        cin>>u>>v;
        grap[u-1].push_back(v);
        grap[v-1].push_back(u);
    }
    bfs(grap,1,-1);
    int q;
    cin>>q;
    cout<<"Level of "<<q<<" = "<<level[q-1];
return 0;
}