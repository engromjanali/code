#include<bits/stdc++.h>
using namespace std;

typedef pair<int,int> pir;
typedef vector<vector<pair<int,int>>> two_d;
two_d grap; // sortcut/method of "vector<vector<pair<int,int>>> grap;".

vector<bool>visited;
vector<int>parent;
vector<int>Distance;

void dijkstra(two_d grap, int s)
{
    priority_queue< pair<int,int> , vector<pair<int,int>> , greater<pair<int,int>> >q; // priority queue depand on frist value of pair.
    Distance[s] = 0;
    q.push({Distance[s],s});
    while (!q.empty())
    {
        pir u = q.top();
        q.pop();
        visited[u.second] = true; 
        for(pair<int,int> x : grap[u.second])
        {
            int v = x.first;
            int w = x.second;

            if(visited[v]) continue;
            if(Distance[v] > w + Distance[u.second])
            {
                Distance[v] = w + Distance[u.second];
                q.push({Distance[v],v});
                parent[v] = u.second;
                // cout<<v<<endl;
            }
        }
    }
}

int main(){

    int n,m;
    cin>>n>>m;

    grap.resize(n);
    visited.resize(n, false);
    parent.resize(n, -1);
    Distance.resize(n, INT_MAX);


    for(int i = 0; i<m; i++)
    {
        int u,v,w;
        cin>>u>>v>>w;
        grap[u].push_back({v,w});
        grap[v].push_back({u,w});
    }

    int s,d;
    cin>>s>>d;
    
    dijkstra(grap, s);

    vector<int>path;
    int current = d;
    while(current != -1)
    {
        path.push_back(current);
        current = parent[current];
    }
    reverse(path.begin(), path.end());
    for( int x : path)
    {
        cout<<x<<" ";
    }
    
return 0;
}