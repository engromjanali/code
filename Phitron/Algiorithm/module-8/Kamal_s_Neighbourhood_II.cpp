#include<bits/stdc++.h>
using namespace std;

vector<vector<int>>grap;
vector<bool>visited;
vector<int>connected;
vector<int>level;

void bfs(vector<vector<int>>grap, int u)
{
    queue<int>q;
    q.push(u);
    visited[u] = true;
    while (!q.empty())
    {
        int v = q.front();
        q.pop();
        for(int x : grap[v])
        {
            if(visited[x]) continue;
            q.push(x);
            visited[x] = true;
            level[x]=level[v]+1;
            connected.push_back(x);
        }
    }
}

int main(){
    int n,m;
    cin>>n>>m;

    grap.resize(n);
    visited.resize(n,false);
    level.resize(n,0);
    
    for(int i =0; i<m; i++)
    {
        int v,u;
        cin>>u>>v;
        grap[u].push_back(v);
    }
    int k;
    cin>>k;
    bfs(grap,k);
    
    cout<<connected.size();
    
return 0;
}