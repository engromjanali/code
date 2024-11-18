#include<bits/stdc++.h>
using namespace std;

typedef vector<vector<int>>two_d;

two_d grap;
vector<int>level;
vector<bool>visited;
vector<int>parent;
int max_level;

void bfs(two_d grap, int s)
{
    queue<int>q;
    q.push(s);
    visited[s-1] = true;
    while(!q.empty())
    {
        int u = q.front();
        q.pop();
        for(int v : grap[u-1])
        {
            if(visited[v-1]) continue;
            max_level = level[u-1] +1;
            visited[v-1] = true;
            level[v-1] = level[u-1]+1;
            parent[v-1] = u;
            q.push(v);
        }
    }
}

int main(){

    //input 
    int n,m;
    cin>>n>>m;
    grap.resize(n);
    visited.resize(n,false);
    parent.resize(n,-1);
    level.resize(n,1); // here level was started from 1.

    for(int i =0; i<m; i++)
    {
        int a,b;
        cin>>a>>b;
        grap[a-1].push_back(b);
        grap[b-1].push_back(a);
    }
    // output
    bool flag = true;
    bfs(grap, 1);
    for(int i =0; i<n; i++)
    {
        if(visited[i]) continue;
        flag = false;
    }
    if(flag)
    {
        
        cout<<level[n-1]<<endl;

        int current = n;
        vector<int>path;
        while(current != -1)
        {
            path.push_back(current);
            current = parent[current-1];
        }
        reverse(path.begin() , path.end());
        for(int x : path)
        {
            cout<<x<<" ";
        }
    }
    else cout<<"IMPOSSIBLE"<<endl;
return 0;
}