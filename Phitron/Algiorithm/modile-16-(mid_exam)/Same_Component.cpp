#include<bits/stdc++.h>
using namespace std;

typedef pair<int,int> pir;
    
int n,m;
vector<string>grap;
vector<vector<bool>>visited;
vector<pir>path = {{-1,0}, {1,0},{0,1},{0,-1}};

bool isValid(pir p)
{
    return (p.first>=0 && p.first<n && p.second>=0 && p.second<m);
}
void dfs(pir s)
{
    visited[s.first][s.second] = true;
    for(pir x : path)
    {
        pir v = {x.first+s.first , x.second+s.second};
        if(!isValid(v) || visited[v.first][v.second] || grap[v.first][v.second]=='-')continue;
        dfs(v);
    }
}
int main(){

    cin>>n>>m;
    visited.resize(n);
    for(int i =0; i<n; i++)
    {
        visited[i].resize(m,false);
    }

    for(int i =0; i<n; i++)
    {
        string s ;
        cin>>s;
        grap.push_back(s);
    }
    pir s,d;
    cin>>s.first>>s.second;
    cin>>d.first>>d.second;

    dfs(s);
    if(visited[d.first][d.second])
        cout<<"YES";
    else cout<<"NO";
return 0;
}