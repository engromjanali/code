#include<bits/stdc++.h>
using namespace std;

typedef pair<int,int> pir;

int n,m;

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

    for (auto& row : visit) {
        row.clear(); // Clear each row
    }
    visit.clear(); // Clear the main vector
    visit.shrink_to_fit(); // Release the allocated memory

    for(int i =0; i<n; i++)
    {
        string a;
        cin>>a;
        grap.push_back(a);
    }

    int cc =0;
    for(int i =0; i<n; i++)
    {
        for(int j =0; j<m; j++)
        {
            if(visited[i][j] || !isValid(i,j) || grap[i][j] =='#') continue;    
            dfs({i,j});
            // cout<<i<<j<<" ";
            cc++;
        }
        // cout<<endl;
    }
    cout<<cc;

return 0;
}