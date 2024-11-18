    //DFS(depth frist search)

#include<bits/stdc++.h>
using namespace std;

vector<bool>visited;
vector<int>depth;
vector<int>height;

void dfs(vector<vector<int>>& grap, int u)
{
    // section 1 : action just after entering node u.
    cout<<"visiting : "<<u<<" depth "<<depth[u-1]<<endl;
    visited[u-1]=true;
    for(int x : grap[u-1])
    {
        // section 2 : action before entering a new naighbor.
        if(visited[x-1]) continue;
        depth[x-1]=depth[u-1]+1;
        dfs(grap,x);
        // section 3 : action after exating a naighbor.
        height[u-1] = max(height[x-1]+1 , height[u-1]);//updating the height of u.
    }
    // action 4 : action before exiting node u.
    cout<<"visiting : "<<u<<" height "<<height[u-1]<<endl;

}
int main(){
    int n,m;
    cin>>n>>m;
    vector<vector<int>>grap(n);
    visited.resize(n,false);
    depth.resize(n,0);
    height.resize(n,0);

    
    // input
    while (m--)
    {
        int u,v;
        cin>>u>>v;

        grap[u-1].push_back(v); 
        grap[v-1].push_back(u); 
    }

    // output

    dfs(grap, 1);
return 0;
}