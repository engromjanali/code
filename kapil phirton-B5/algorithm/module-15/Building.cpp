//https://www.hackerrank.com/contests/assignment-02-a-introduction-to-algorithms-a-batch-05/challenges/building-3-1
#include<bits/stdc++.h>
using namespace std;
typedef pair<int,int> pir;
vector<bool>visited;
vector<int>parent(100000, -1);
vector<int>level(100000,  1);

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
bool cmp(edge a , edge b){
    return a.w < b.w;   
}
int dsu_find(int s)
{
    int current= s;
    while (-1 != parent[current])
    {
        current = parent[current];
    }
    return current;
}
void dsu_union(int a, int b) // optimized
{
    int leaderA = dsu_find(a);
    int leaderB = dsu_find(b);
    
    if(leaderA != leaderB)
    {
        int lavelA = level[leaderA];
        int lavelB = level[leaderB];

        if(lavelA > lavelB)
        {
            parent[leaderB] = leaderA;// new leader A.
        }
        else if(lavelA < lavelB){
            parent[leaderA] = leaderB;// new leader B.
        }
        else{
            parent[leaderB] = leaderA;// new leader A.
            level[leaderA]++; //leader of lavel increment.
        }
    }
}

vector<edge> kruskal_s_algorithm(vector<edge>list_of_edge)
{
    vector<edge>list_of_edge_ans;
    sort(list_of_edge.begin(), list_of_edge.end(), cmp);

    for(edge x : list_of_edge)
    {
        int leaderA = dsu_find(x.a);
        int leaderB = dsu_find(x.b);

        if(leaderA != leaderB)
        {
            dsu_union(x.a , x.b);
            list_of_edge_ans.push_back(x);
        }
    }

return list_of_edge_ans;
}

int main(){

    int n,m;
    cin>>n>>m;
    vector<edge>list_of_edge;
    visited.resize(n+1, false);
    while(m--)
    {
        int a,b,w;
        cin>>a>>b>>w;
        list_of_edge.push_back(edge(a,b,w));
    }

    vector<edge>list_of_edge_ans;
    list_of_edge_ans = kruskal_s_algorithm(list_of_edge);
    
    if(list_of_edge_ans.size()+1 != n) cout<<"-1"<<endl;
    
    else{
        long long ans = 0;
        for(edge x : list_of_edge_ans)
        {
            ans+=x.w;
        }
        cout<<ans<<endl;
    } 

return 0;
}