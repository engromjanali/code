//https://www.hackerrank.com/contests/assignment-02-a-introduction-to-algorithms-a-batch-05/challenges/area-of-component
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
int counts =0;
void dfs(pir s)
{
    visited[s.first][s.second] = true;
    counts++;
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
    int res =INT_MAX;
    for(int i =0; i<n; i++)
    {
        for(int j =0; j<m; j++)
        {
            if(visited[i][j] || grap[i][j]=='-') continue;
            counts =0;
            dfs({i,j});
            res = min(res,counts);
        }
    }
    if(res ==INT_MAX) cout<<"-1";
    else cout<<res;
return 0;
}