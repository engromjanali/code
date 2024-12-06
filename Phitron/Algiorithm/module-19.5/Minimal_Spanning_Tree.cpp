#include<bits/stdc++.h>
using namespace std;
vector<int>parent(100005, -1);
vector<int>parentSize(100005,  1);
class edge{
    public :
    int a;
    int b;
    int w;
    edge(int a, int b, int w)
    {
        this->a = a;
        this->b = b;
        this->w = w;
    }
};
int dsu_find(int current)
{
    while(parent[current] != -1)
    {
        current = parent[current];
    }
    return current;
}

void dsu_union(int a, int b)
{
    int leaderA = dsu_find(a);
    int leaderB = dsu_find(b);

    if(leaderA != leaderB)
    {
        if(parentSize[leaderA] > parentSize[leaderB])
        {
            parent[leaderB] = leaderA;
            parentSize[leaderA] += parentSize[leaderB];
        }
        else{
            parent[leaderA] = leaderB;
            parentSize[leaderB] += parentSize[leaderA];
        }
    }
}
bool cmp(edge a , edge b)
{
    return a.w<b.w;
}
vector<edge> kruskal_s_algorith(vector<edge>list_of_edge)
{
    vector<edge>list_of_edge_ans;
    sort(list_of_edge.begin(), list_of_edge.end(), cmp);
    
    for(edge x : list_of_edge)
    {
        int leaderA = dsu_find(x.a); 
        int leaderB = dsu_find(x.b);

        if(leaderA == leaderB) continue;
        dsu_union(x.a , x.b);
        list_of_edge_ans.push_back(x); 
    }
    return list_of_edge_ans;
}
int main(){

    int n,m;
    cin>>n>>m;
    vector<edge>list_of_edge;
    while(m--)
    {
        int a,b,w;
        cin>>a>>b>>w;
        list_of_edge.push_back(edge(a,b,w));
    }
    vector<edge>list_of_edge_ans = kruskal_s_algorith(list_of_edge);
    long long int ans = 0;
    for(edge x : list_of_edge_ans)
    {
        ans +=  x.w;
    }
    cout<<ans;
return 0;
}