// input                  // Output          
// 6 9                      6
// 1 2 5 
// 2 3 2 
// 1 3 10
// 3 4 1
// 4 1 5 
// 1 5 9
// 5 6 1
// 2 6 4 
// 2 5 2 
// 4 6

#include<bits/stdc++.h>
using namespace std;
typedef pair<int,int> pir;
vector<vector<pir>>grap;
vector<int>Distance;
vector<bool>visited;
vector<int>level;

void dijkstra(int u)
{
    priority_queue<pir, vector<pir>, greater<pir>>q;
    Distance[u-1] = 0;
    q.push({0,u});
    while(!q.empty())
    {
        pir v = q.top();
        q.pop();
        if(visited[v.second-1]) continue;
        visited[v.second-1] = true;
        for( pir x : grap[v.second-1])
        {
            if(Distance[x.first-1] > x.second + Distance[v.second-1])
            {
                Distance[x.first-1] = x.second+Distance[v.second-1];
                q.push({Distance[x.first-1], x.first});
                level[x.first-1] = level[v.second-1]+1;
            }
        }
    }
}

int main(){

    int n,m;
    cin>>n>>m;
    grap.resize(n);
    visited.resize(n,false);
    level.resize(n,0);
    Distance.resize(n,INT_MAX);

    while(m--)
    {
        int a,b,w;
        cin >>a>>b>>w;
        grap[a-1].push_back({b,w});
        grap[b-1].push_back({a,w});
    }
    int s,d;
    cin>>s>>d;
    dijkstra(s);
    cout << Distance[d-1]<<endl;
    cout<<level[d-1];
return 0;
}