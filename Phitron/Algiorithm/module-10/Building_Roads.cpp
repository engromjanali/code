#include<bits/stdc++.h>
using namespace std;

typedef vector<vector<int>> two_d;
vector<int>visited;

void dfs(two_d & grap, int u)
{
    visited[u-1] = true;
    for(int x : grap[u-1])
    {
        if(visited[x-1]) continue;
        dfs(grap, x);
    }
}

int main(){

    int n,m;
    cin>>n>>m;
    two_d grap(n);
    visited.resize(n, false);

    while ((m--))
    {
        int a,b;
        cin>>a>>b;
        grap[a-1].push_back(b);
        grap[b-1].push_back(a);
    }
    //output 
    vector<int>cc;
    for(int i =1; i<=n; i++)
    {
        if(visited[i-1]) continue;
        dfs(grap,i);
        cc.push_back(i);
    }
    cout<<cc.size()-1<<endl;
    for(int i =1; i<cc.size(); i++)
    {
        cout<<cc[i-1]<<" "<<cc[i]<<endl;
    }

return 0;
}