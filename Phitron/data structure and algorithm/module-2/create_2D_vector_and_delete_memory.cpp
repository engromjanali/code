#include<bits/stdc++.h>
using namespace std;

vector<vector<bool>>visited;

void dfs()
{
    for(int i =0; i<visited.size(); i++)
    {
        for(int j=0; j<visited[0].size(); j++)
        {
            cout<<visited[i][j]<<""; 
        }
        cout<<endl;
    }
}
int main(){

    int n,m;
    cin>>n>>m;
    vector<vector<bool>>visit(n,vector<bool>(m, false));
    visited = visit;

    // Explicitly clear memory
    for (auto& row : visit) {
        row.clear(); // Clear each row
    }
    visit.clear(); // Clear the main vector
    visit.shrink_to_fit(); // Release the allocated memory

    dfs();

return 0;
}