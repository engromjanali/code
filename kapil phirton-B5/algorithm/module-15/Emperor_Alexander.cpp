// https://www.hackerrank.com/contests/assignment-02-a-introduction-to-algorithms-a-batch-05/challenges/emperor-alexander

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
    while (!pq.empty()) // O(v^2) or O(E log v)
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
    for(int i=0; i<m; i++)
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
    long long res=0;
    for(edge x : list_of_edges)
    {
        res+= x.w;
    }
    if(n==list_of_edges.size()+1)
    {
        cout<<m-(n-1)<<" "<< res<<endl;
    }
    else cout<<"Not Possible"<<endl;

return 0;
}