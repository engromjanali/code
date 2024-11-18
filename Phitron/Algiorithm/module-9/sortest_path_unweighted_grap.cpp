
#include<bits/stdc++.h>
using namespace std;

typedef vector<vector<int>> two_d;

vector<vector<int>>grap;
//two_d grap; // it's valid also.

vector<bool>visited;
vector<int>parent;

void bfs(two_d grap, int u)
{
    queue<int>q;
    q.push(u);
    visited[u]=true;
    while (!q.empty())
    {
        int v = q.front();
        q.pop();
        for(int x : grap[v])
        {
            if(visited[x]) continue;
            q.push(x);
            visited[x] = true;
            parent[x] = v;
        }
    }
}

int main(){

    int n,m;
    cin>>n>>m;

    grap.resize(n);
    visited.resize(n, false);
    parent.resize(n, -1);

    for(int i = 0; i<m; i++)
    {
        int u,v;
        cin>>u>>v;
        grap[u].push_back(v);
        grap[v].push_back(u);
    }

    int s,d;
    cin>>s>>d;
    
    bfs(grap, s);

    vector<int>path;
    int current = d;
    while(current != -1)
    {
        path.push_back(current);
        current = parent[current];
    }
    reverse(path.begin(), path.end());
    for( int x : path)
    {
        cout<<x<<" ";
    }
    
return 0;
}