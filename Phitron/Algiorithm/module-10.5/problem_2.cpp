#include<bits/stdc++.h>
using namespace std;

typedef pair<int,int> pir;
int n ,m;

vector<string>grap;
vector<pir> path = {{1,0},{-1,0},{0,1}, {0,-1}};

vector<vector<bool>>visited;
vector<vector<pir>>parent;
vector<vector<int>>level;

bool isValid(pir p)
{
    return (p.first>=0 && p.second>=0 && p.first<n && p.second<m);
}

void bfs(pir s)
{
    queue<pir>q;
    q.push(s);
    visited[s.first][s.second] = true;
    while(!q.empty())
    {
        pir u = q.front();
        q.pop();
        for(pir v : path)
        {
            pir x = {v.first+u.first , v.second+u.second};
            if(!isValid(x) ||visited[x.first][x.second] || grap[x.first][x.second]=='#') continue;
            q.push(x);
            visited[x.first][x.second] = true;
            level[x.first][x.second] = level[u.first][u.second] + 1;
            parent[x.first][x.second] = u;
        }
    }
}
int main(){

    pir A,B;
    cin>>n>>m;

    vector<vector<bool>>visit(n,vector<bool>(m,false));
    vector<vector<pir>>prnt(n,vector<pir>(m,{-1,-1}));
    vector<vector<int>>lvl(n,vector<int>(m,0));
    visited = visit;
    parent = prnt;
    level = lvl;
    
    for (int i =0; i<m; i++)
    {
        string a;
        cin>>a;
        grap.push_back(a);

        for(int j=0; j<grap[i].size(); j++)
        {
            if(grap[i][j] =='a') A = {i,j};
            if(grap[i][j] =='e') B = {i,j};
        }
    }
    bfs(A);
    if(level[B.first][B.second]==0)
        cout<<"NO";
    else{
        cout<<"YES"<<endl;
        cout<<level[B.first][B.second]<<endl;
    }
    pir current = B;
    vector<pir>rode;
    while (!(current == parent[A.first][A.second]))
    {
        rode.push_back(current);
        current = parent[current.first][current.second];
    }
    reverse(rode.begin() ,  rode.end());
    for(int i =1; i< rode.size(); i++)
    {
        if(rode[i].first==rode[i-1].first)
        {
            if(rode[i-1].second == rode[i].second-1)
            {
                cout<<"R";
            }
            else cout<<"L";
        }
        else {

            if(rode[i-1].first == rode[i].first-1)
            {
                cout<<"D";
            }
            else cout<<"U";
        }
    }
return 0;
}