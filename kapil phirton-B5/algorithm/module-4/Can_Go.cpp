#include<bits/stdc++.h>
using namespace std;

typedef pair<int,int> pir;

int n,m;
pir A,B;

vector<string>grap;
vector<vector<bool>>visited;


vector<pir> path = {{-1,0}, {1,0}, {0,1},{0,-1}};
bool isValid(int i, int j)
{
    return (i>=0 && i<n &&j>=0 && j<m);
}

void dfs(pir u)
{
    if(!isValid(u.first, u.second)) return;
    if(visited[u.first][u.second]) return;
    if(grap[u.first][u.second] == '#') return;

    visited[u.first][u.second]= true;

    for(pir p : path)
    {
        dfs({p.first+u.first, p.second+u.second});
    }
}

int main(){

    cin>>n>>m;
    vector<vector<bool>>visit(n,vector<bool>(m, false));
    visited = visit;

    for(int i =0; i<n; i++)
    {
        string a;
        cin>>a;
        grap.push_back(a);
        for(int j =0; j<m; j++)
        {
            if(a[j] == 'A') A ={i,j};
            if(a[j] == 'B') B ={i,j};
        }
    }
    dfs(A);
    if(visited[B.first][B.second] == 0)
        cout<<"NO";
    else{
        cout<<"YES"<<endl;
    }

return 0;
}