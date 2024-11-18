#include<bits/stdc++.h>
using namespace std;

vector<bool>visited;
stack<int>stk;

void bfs(vector<vector<int>>&grap, int u)
{
    
    queue<int>q;
    q.push(u);
    visited[u-1] = true;
    
    while (!q.empty())
    {
        int v = q.front();
        q.pop();
        for(int x : grap[v-1])
        {
            if(visited[x-1]) continue;
            q.push(x);
            visited[x-1] = true;
        }
        stk.push(v); 
    }
}

int main(){

    int n,m;
    cin>>n>>m;
    vector<vector<int>>grap(n);
    visited.resize(n , false);
    for(int  i = 0; i<m; i++)
    {
        int u,v;
        cin>>u>>v;

        grap[u-1].push_back(v);
        grap[v-1].push_back(u);
    }

    bfs(grap,1);
    while(!stk.empty())
    {
        cout<<stk.top()<<" ";
        stk.pop();
    }
return 0;
}