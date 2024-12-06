// https://www.hackerrank.com/contests/assignment-04-a-introduction-to-algorithms-a-batch-03/challenges/cycle-of-edges
#include<bits/stdc++.h>
using namespace std;
vector<int>parent(100005, -1);
vector<int>Size(100005,  1);

int dsu_find(int current)
{
    while (-1 != parent[current])
    {
        current = parent[current];
    }
    return current;
}

void dsu_union(int a, int b)
{
    int leaderA = dsu_find(a);
    int leaderB = dsu_find(b);

    if(leaderA !=  leaderB)
    {
        if(Size[leaderA] >= leaderB)
        {
            parent[leaderB] = leaderA;
            Size[leaderA] += Size[leaderB];
        }
        else{
            parent[leaderA] = leaderB;
            Size[leaderB] += Size[leaderA];
        }
    }
}
int main(){

    int n,m;
    cin>>n>>m;
    vector<pair<int,int>>list_of_edge;
    for(int i =1; i<=m; i++)
    {
        int a,b;
        cin>>a>>b;
        list_of_edge.push_back({a,b});
    }
    int cycle=0;
    while(!list_of_edge.empty())
    {
        pair<int,int>edge = list_of_edge.back();
        list_of_edge.pop_back();
        
        int leaderA = dsu_find(edge.first);
        int leaderB = dsu_find(edge.second);

        if(leaderA== leaderB)
            cycle++;
        else dsu_union(leaderA,leaderB);
    }
    cout<<cycle;
return 0;
}