#include<bits/stdc++.h>
using namespace std;

vector<vector<int>>grap;
vector<bool>visited;
vector<int>level;
int connected;

void bfs(vector<vector<int>>grap, int u)
{
    queue<int>q;
    q.push(u);
    visited[u] = true;
    while (!q.empty())
    {
        int v = q.front();
        q.pop();
        connected++;
        for(int x : grap[v])
        {
            if(visited[x]) continue;
            q.push(x);
            visited[x] = true;
            level[x]=level[v]+1;
        }
    }
}

int main(){
    int n,m;
    cin>>n>>m;

    grap.resize(1001);
    visited.resize(1001,false);
    level.resize(1001,0);
    
    for(int i =0; i<m; i++)
    {
        int v,u;
        cin>>u>>v;
        grap[u].push_back(v);
        grap[v].push_back(u);
    }
    // Output
    vector<int>c_component;
    for(int i =0; i<1001; i++)
    {
        connected=0;

        if(visited[i]) continue;
        bfs(grap,i);
        if(connected>1) c_component.push_back(connected);
    }

    sort(c_component.begin(), c_component.end());

    for(int x : c_component)
    {
        cout<<x<<" ";
    }
return 0;
}