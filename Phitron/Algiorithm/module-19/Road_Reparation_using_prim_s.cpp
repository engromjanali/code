//https://cses.fi/problemset/task/1675/
#include<bits/stdc++.h>
using namespace std;
typedef pair<int,int>pir;
vector<bool>visited;

class cmp{
public:
    bool operator()(pair<pir,int> a, pair<pir,int> b){
        return a.second > b.second;
    }
};

vector<pair<pir,int>> prim_s_algorithm(vector<vector<pir>> grap, int s)
{
    vector<pair<pir,int>> list_of_edge_ans;

    priority_queue<pair<pir,int>, vector<pair<pir,int>>, cmp>pq;
    pq.push({{s,s} , 0});
    while(!pq.empty())
    {
        pair<pir,int> u = pq.top();
        pq.pop();
        if(visited[u.first.second]) continue;
        visited[u.first.second] = true;
        list_of_edge_ans.push_back(u);
        for(pir x : grap[u.first.second])
        {
            pq.push({{u.first.second, x.first}, x.second});
        }
    }
    return list_of_edge_ans;
}
int main(){

    int n,m;
    cin>>n>>m;
    visited.resize(n+1, false);
    vector<vector<pir>>grap(n+1);
    while (m--)
    {
        int a,b,w;
        cin>>a>>b>>w;
        grap[a].push_back({b,w});
        grap[b].push_back({a,w});
    }
    vector<pair<pir,int>>list_of_edge_ans = prim_s_algorithm(grap, 1);
    list_of_edge_ans.erase(list_of_edge_ans.begin());
    if(list_of_edge_ans.size() == n-1)
    {
        long long int ans =0;
        for(pair<pir,int> x : list_of_edge_ans)
        {
            ans += x.second;
        }
        cout<<ans<<endl;
    }
    else cout<<"IMPOSSIBLE"<<endl;
return 0;
}