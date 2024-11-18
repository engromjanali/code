#include<bits/stdc++.h>
using namespace std;

vector<vector<int>>grap;
vector<int>visited;

void dfs(vector<vector<int>>& grap, int u)
{
    // section 1 : action just after entering node u.
    visited[u-1]=true;
    for(int x : grap[u-1])
    {
        // section 2 : action before entering a new naighbor.
        if(visited[x-1]) continue;
        dfs(grap,x);
        // section 3 : action after exating a naighbor.
    }
    // action 4 : action before exiting node u.
    cout<<u<<" "<<endl;
}

int main(){

    int n, m;
    cin>>n>>m;
    grap.resize(n);
    visited.resize(n, false);

    // input
    for(int i =0; i<m; i++)
    {
        int u,v;
        cin>>u>>v;

        grap[u-1].push_back(v);
    }

    int element =0;
    for(int i=0; i<visited.size(); i++)
    {
        if(visited[i]) continue;
        else{
            element++;
            cout<<"element "<<element<<" :->"<<endl;
            dfs(grap,i+1); //it's valid also. but dfs print advance argument or fast 1.
        }
    }
    
return 0;
}

