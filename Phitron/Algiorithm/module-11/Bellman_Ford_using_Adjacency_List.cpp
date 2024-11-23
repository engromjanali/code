// limitation of bellman_ford algorithm :
    // it's work with only directed not undirected.
    // the algorithm dosen't support negitive weighted cycle.
        // we cann't solve the problem but can detectd the cycle.
        // the Bellman Ford run for (N-1) times. if we run it for more one time if we feel/notice any changes thst's mean negitive cycle have. 
        // otherwise we don't see any changes.
        // remember some time we can't detected cycle because negitive weight less then increment of this cycle. example increment (2+3 > -1). for example we don't get "cycle_detected".        
    
#include<bits/stdc++.h>
using namespace std;

typedef pair<int,int>pir;

int n,m;
vector<int>Distance;
vector<vector<pir>>grap;
// remamber it's work for (when start node from 0).
void bellman_ford(int s) // by Adjacency List
{
    Distance[s] = 0;
    for(int i =0; i<n; i++) // O(N * M) // traverse N time full Grap
    {
        for(int u =0; u<n; u++) // O(M) // raverse full Grap
        {
            for(pir x : grap[u]) // traverse naighvor or all edges relaxation
            {
                int v = x.first;
                int w = x.second;

                if(Distance[u] + w < Distance[v])
                {
                    Distance[v] = Distance[u] + w;
                }
            }
        }
    }
}


int main(){

    cin>>n>>m;

    grap.resize(n);
    Distance.resize(n,INT_MAX);
    while(m--)
    {
        int a,b,w;
        cin>>a>>b>>w;
        grap[a].push_back({b,w});
    }
    int s,d;
    cin>>s>>d;
    bellman_ford(s);
    // cout<<Distance[d];
    for(int i =0; i<n; i++)
    {
        cout<<Distance[i]<<" ";
    }
 
    return 0;
}