// https://www.naukri.com/code360/problems/bellmon-ford_2041977?leftPanelTabValue=PROBLEM
#include<bits/stdc++.h>
using namespace std;

vector<pair<pair<int,int>,int>>list_of_edges;
vector<int>Distance;

void bellman_ford(int s, int n) //O(N * M) //by List of Edges.
{    
    Distance[s] =0;
	for(int i=1; i<n;i++)
	{
		for(auto edge: list_of_edges) //O(M) // traverse full grap or all edges relaxation
		{
			int u = edge.first.first;
			int v = edge.first.second;
			int w = edge.second;

			if(Distance[u]<=100000000 && Distance[v] > Distance[u]+w) // remember if we don't use "Distance[u] < INT_MAX" it. if Distance[u]+w geter-then INT_MAX we get a error or wrong value/ans. 
				Distance[v] = Distance[u] + w;
		}
	}
}

vector<int> bellmonFord(int n, int m, int src, vector<vector<int>> &edges) {
    Distance.clear();  
    Distance.resize(n+1, 100000000);

    list_of_edges.clear();
    for(int i =0; i<m; i++)
    {
        list_of_edges.push_back({ {edges[i][0],edges[i][1]} , edges[i][2] });   
    }
    bellman_ford(src,n);
    return Distance;

}



