#include<bits/stdc++.h>
using namespace std;

typedef pair<int,int> pir;

int n,m;

vector<string>grap;
vector<vector<bool>>visited;

vector<pir> path = {{-1,0}, {1,0}, {0,1}, {0,-1}};
bool isValid(int i, int j)
{
    return (i>=0 && i<n &&j>=0 && j<m);
}
int dfs(pir u)
{
    if(!isValid(u.first, u.second)) return 0;
    if(visited[u.first][u.second]) return 0;
    if(grap[u.first][u.second] == '#') return 0;

    visited[u.first][u.second]= true;
    int derection[4]={0};
    for(int i =0; i<4; i++)
    {
        pir p = path[i];
        derection[i] = dfs({p.first+u.first, p.second+u.second});
    }
    return derection[0]+derection[1]+derection[2]+derection[3]+1;
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
    vector<int>apartment_size;
    for(int i =0; i<n; i++)
    {
        for(int j =0; j<m; j++)
        {
            if(visited[i][j] || !isValid(i,j) || grap[i][j] =='#') continue;    
            int a = dfs({i,j});
            apartment_size.push_back(a);
        }
    }
    sort(apartment_size.begin(), apartment_size.end());
    for(int x : apartment_size)
    {
        cout<<x<<" ";
    }
    if(apartment_size.empty()) cout<<"0";

return 0;
}