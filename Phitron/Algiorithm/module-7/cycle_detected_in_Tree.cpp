#include<bits/stdc++.h>
using namespace std;

vector<vector<int>>grap;
vector<int>visited;
vector<int>level;

bool dfs(vector<vector<int>>& grap, int u, int prent)
{
    bool cycleDetected = false;

    visited[u-1]=true;
    for(int x : grap[u-1])
    {
        if(x == prent) continue;
        if(visited[x-1]) return true;
        cycleDetected |= dfs(grap,x,u);
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
    
    for(int i=0; i<visited.size(); i++)
    {
        if(visited[i]) continue;
        else{
            cycle_detected |= dfs(grap,i+1,-1);
        }
    }
    if(cycle_detected)
        cout<<"Cycle Dtected"<<endl;
    else cout<<"Cycle Dosn't Dtected"<<endl;
    
return 0;
}

