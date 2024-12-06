// we need to store connected component
// and cycled edge.

// single day can close a cycle and create a join with two connected component.
#include<bits/stdc++.h>
using namespace std;
vector<int>parent(1001, -1);
vector<int>level(1001, 1);
int dsu_find(int a)
{
    while(-1 != parent[a])
    {
        a = parent[a];
    }
    return a;
}
void dsu_union(int a, int b)
{
    int leaderA = dsu_find(a);
    int leaderB = dsu_find(b);
    if(leaderA != leaderB)
    {
        if(level[leaderA] > level[leaderB])
        {
            parent[leaderB] = leaderA;
            level[leaderA] += level[leaderB];
        }
        else if(level[leaderA] < level[leaderB])
        {
            parent[leaderA] = leaderB;
            level[leaderB] += level[leaderA];
        }
        else{
            parent[leaderB] = leaderA;
            level[leaderA] += level[leaderB];
        }
    }
}
int main(){

    int n;
    cin>>n;
    map<int,bool>mp;
    vector<pair<int,int>>cycle;
    vector<pair<int,int>>list_of_edge;
    for(int i =0; i<n-1; i++)
    {
        int a ,b;
        cin>>a>>b;
        int A = dsu_find(a);
        int B = dsu_find(b);
        if(A==B)
            cycle.push_back({a,b});
        else{
            dsu_union(A,B);
        }
    }
    vector<int>leader;
    for(int i =1; i<=n; i++)
    {
        if(parent[i]==-1)
        leader.push_back(i);
    }
    cout<<max(leader.size()-1,cycle.size())<<endl;
    for(int i =0; i< max(leader.size(),cycle.size()); i++)
    {
        if(i<cycle.size())
        {
            cout<<cycle[i].first<<" "<<cycle[i].second<<" ";
        }
        if(i<leader.size()-1)
        {
            cout<<leader[i]<<" "<<leader[i+1];
        }
        cout<<endl;
    }
return 0;
}