// 1 2 4
// 1 5 2
// 1 4 10
// 2 3 18
// 2 4 8
// 3 4 11
// 4 5 5
// 4 7 11
// 4 8 9
// 6 7 1
// 6 8 2


#include<bits/stdc++.h>
using namespace std;
typedef pair<int,int>pir;

vector<bool>visited;
class edge{
    public:
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
class cmp{
    public:
    bool operator()(edge a, edge b)
    {
        return (a.w>b.w);
    }
};
vector<edge> prim_s_algorithm(vector<vector<pir>>grap, int s)
{
    vector<edge>list_of_edge;

    priority_queue<edge, vector<edge>, cmp>pq;
    pq.push(edge{s,s,0});
    while (!pq.empty())
    {
        edge u = pq.top();
        pq.pop();
        if(visited[u.b]) continue;
        list_of_edge.push_back(u);
        visited[u.b] = true;
        for(pir x : grap[u.b])
        {
            if(visited[x.first]) continue;
            pq.push(edge(u.b , x.first , x.second));
        }
    }
    return list_of_edge;
}

int main(){

    int n,m;
    cin>>n>>m;
    vector<vector<pir>>grap(n+1);
    visited.resize(n+1, false);
    while ((m--))
    {
        int a ,b, w;
        cin>>a>>b>>w;
        grap[a].push_back({b,w});
        grap[b].push_back({a,w});
    }

    vector<edge> list_of_edges = prim_s_algorithm(grap, 1);
    grap.clear();
    grap.shrink_to_fit();

    list_of_edges.erase(list_of_edges.begin());
    for(edge x : list_of_edges)
    {
        cout<<x.a<<" "<<x.b<<" "<<x.w<<endl;
    }

return 0;
}