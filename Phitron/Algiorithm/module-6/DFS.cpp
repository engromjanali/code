    //DFS(depth frist search)

#include<bits/stdc++.h>
using namespace std;

vector<bool>visited;

void dfs(vector<vector<int>>& grap, int u)
{
    // section 1 : action just after entering node u.
    cout<<"visiting : "<<u<<endl;
    visited[u-1]=true;
    for(int x : grap[u-1])
    {
        // section 2 : action before entering a new naighbor.
        if(visited[x-1]) continue;
        dfs(grap,x);
        // section 3 : action after exating a naighbor.
    }
    // action 4 : action before exiting node u.
}
int main(){
    int n,m;
    cin>>n>>m;
    vector<vector<int>>grap(n);
    visited.resize(n,false);

    
    // input
    while (m--)
    {
        int u,v;
        cin>>u>>v;

        grap[u-1].push_back(v); 
        grap[v-1].push_back(u); 
    }

    // output
    for(int i =0; i < grap.size();i++)
    {
        for(int j =0; j<grap[i].size(); j++)
        {
            cout<<grap[i][j]<<" ";
        }
        cout<<endl;
    }

    dfs(grap, 1);
return 0;
}