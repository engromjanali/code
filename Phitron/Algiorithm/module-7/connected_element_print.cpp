#include<bits/stdc++.h>
using namespace std;

vector<vector<int>>grap;
vector<int>visited;
vector<int>level;

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

void bfs(vector<vector<int>>&grap, int a)
{
    queue<int>q;
    q.push(a);
    visited[a-1] = true;

    while(!q.empty())
    {
        int A = q.front();
        q.pop();
        cout<<"Node "<<A<< " level "<<level[A-1]<<endl;

        for(int x :grap[A-1])
        {
            if(visited[x-1]) continue;
            q.push(x);
            visited[x-1] = true;
            level[x-1] = level[A-1]+1;
        }
    }
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

    int element =0;
    for(int i=0; i<visited.size(); i++)
    {
        if(visited[i]) continue;
        else{
            element++;
            cout<<"element "<<element<<" :->"<<endl;
            bfs(grap,i+1);
            // dfs(grap,i+1); //it's valid also. but dfs print advance argument or fast 1.
        }
    }
    
return 0;
}

