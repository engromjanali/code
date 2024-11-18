#include<bits/stdc++.h>
using namespace std;

vector<vector<int>>grap;
vector<int>visited;
vector<int>level;

bool bfs(vector<vector<int>>& grap, int u, int prent)
{
    bool cycleDetected = false;
    queue<int>q;
    q.push(u);
    visited[u-1] = true;
    
    while(!q.empty())
    {
        int v = q.front();
        q.pop();
        for(int x : grap[v-1])
        {
            if(x==v) continue;
            if(visited[x-1])
            {
                cycleDetected = true;
                continue;
            }
            visited[x-1] = true;
            q.push(x);
        }
    }
    return cycleDetected;
}

int main(){

    int n, m;
    cin>>n>>m;
    grap.resize(n);
    visited.resize(n, false);
    level.resize(n,0);

    // input
    for(int i =0; i<m; i++)
    {
        int u,v;
        cin>>u>>v;

        grap[u-1].push_back(v);
    }

    bool cycle_detected = false;
    
    int cc = 0;
    for(int i=0; i<visited.size(); i++)
    {
        if(visited[i]) continue;
        else{
            cc++;
            cycle_detected |= bfs(grap,i+1,-1);
        }
    }
    if(cycle_detected)
        cout<<"Cycle Dtected"<<endl;
    else cout<<"Cycle Dosn't Dtected"<<endl;
    cout<<"count of connected component = "<<cc<<endl;
    
return 0;
}

