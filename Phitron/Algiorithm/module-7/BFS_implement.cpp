#include<bits/stdc++.h>
using namespace std;

vector<vector<int>>grap;
vector<int>visited;
vector<int>level;

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

    // // output
    // for(int i =0; i < grap.size();i++)
    // {
    //     for(int j =0; j<grap[i].size(); j++)
    //     {
    //         cout<<grap[i][j]<<" ";
    //     }
    //     cout<<endl;
    // }

    bfs(grap,1);
return 0;
}