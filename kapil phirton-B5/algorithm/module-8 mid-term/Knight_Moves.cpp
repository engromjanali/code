#include<bits/stdc++.h>
using namespace std;
    
int n,m;

typedef pair<int,int> pir;
vector<vector<int>>grap;
vector<vector<int>>level;
vector<vector<bool>>visited;

vector<pir>path = {{2,-1},{2,1},{-2,-1},{-2,1},{-1,2},{1,2},{-1,-2},{1,-2}};

bool isValid(pir s)
{
    return (s.first>=0 && s.first<n && s.second>=0 && s.second<m);
}
void bfs(pir s)
{
    queue<pir>q;
    q.push(s);
    visited[s.first][s.second] = true;

    while (!q.empty())
    {
        pir u = q.front();
        q.pop();
        for(pir x : path)
        {
            pir v = {x.first+u.first , x.second+u.second};
            if(!isValid(v) || visited[v.first][v.second]) continue;
            q.push(v);
            visited[v.first][v.second] = true;
            level[v.first][v.second] = level[u.first][u.second] +1;
        }
    }
    
}
int main(){

int  t;
cin>>t;
while (t--)
{
    cin>>n>>m;
    
    grap.resize(n);
    visited.resize(n);
    level.resize(n);
    
    for(int i=0; i<n; i++)
    {
        grap[i].resize(0,0);
        grap[i].resize(m,0);
    }

    for(int i=0; i<n; i++)
    {
        level[i].resize(0,0);
        level[i].resize(m,0);
    }

    for(int i=0; i<n; i++)
    {
        visited[i].resize(0,false);
        visited[i].resize(m,false);
    }

    pir s,d;
    cin>>s.first>>s.second;
    cin>>d.first>>d.second;
    bfs(s);
    if(visited[d.first][d.second]) 
        cout<<level[d.first][d.second]<<endl;
    else cout<<"-1"<<endl;
}

return 0;
}