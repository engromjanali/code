
#include<bits/stdc++.h>
using namespace std;
vector<vector<int>>grap;
vector<bool>visited;
vector<int>level;
void dfs(vector<vector<int>>grap, int u)
{
    queue<int>q;
    q.push(u);
    visited[u]= true; // here vertices started from 0. so don't -1.
    while(!q.empty())
    {
        int v = q.front();
        q.pop();
        for(int x : grap[v])
        {
            if(visited[x]) continue;
            q.push(x);
            visited[x]= true;
            level[x] = level[v]+1;
            // cout<<x<<" test "<<level[x]<<endl;
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
    while (q--)
    {
        int res=0;
        visited.clear();
        visited.resize(100001,false);
        level.clear();
        level.resize(100001,0);

        int d,s;
        cin>>s>>d;


        dfs(grap,s);  
        res = level[d];
        if(!visited[s] || !visited[d]) // if there has connected component or our s and d dose not visited that's mean s and d are not connected to himself.
        {
            cout<<"-1\n";
            continue;
        }
        cout<<res<<endl;
    }
return 0;
}