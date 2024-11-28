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
vector<pair<pir,int>>list_of_edges;

// remamber it's work for (when start node from 0).
void bellman_ford(int s) //O(N * M) //by List of Edges.
{    
    Distance[s] =0;
	for(int i=1; i<n;i++)
	{
		for(auto edge: list_of_edges) //O(M) // traverse full grap or all edges relaxation
		{
			int u = edge.first.first;
			int v = edge.first.second;
			int w = edge.second;

			if(Distance[u]<INT_MAX && Distance[v] > Distance[u]+w) // remember if we don't use "Distance[u] < INT_MAX" it. if Distance[u]+w geter-then INT_MAX we get a error or wrong value/ans. 
				Distance[v] = Distance[u] + w;
		}
	}
}

int main(){

    cin>>n>>m;

    Distance.resize(n,INT_MAX);
    while(m--)
    {
        int a,b,w;
        cin>>a>>b>>w;
        list_of_edges.push_back({{a,b},w});
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