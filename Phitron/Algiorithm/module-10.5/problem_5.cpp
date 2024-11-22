#include<bits/stdc++.h>
using namespace std;

typedef pair<int,int> pir;

int n,m;
pir A,B;

vector<string>grap;
vector<vector<bool>>visited;
vector<vector<int>>level;
vector<vector<pir>>parent;

vector<pir> path = {{-1,0}, {1,0}, {0,1},{0,-1}};
bool isValid(int i, int j)
{
    return (i>=0 && i<n &&j>=0 && j<m);
}
void bfs(pir u)
{
    queue<pir>q;
    q.push(u);
    visited[u.first][u.second] = true;
    level[u.first][u.second] = 0;
    while(!q.empty())
    {
        pir v = q.front();
        q.pop();
        for(pir xx : path)
        {
            pir x = {xx.first+v.first  ,  xx.second+v.second};
            if(!isValid(x.first, x.second) || visited[x.first][x.second] || grap[x.first][x.second] =='#') continue;
            q.push({x.first , x.second});
            visited[x.first][x.second]=true;
            level[x.first][x.second] =level[v.first][v.second] + 1;
            parent[x.first][x.second] = {v.first , v.second};
        }       
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

    vector<vector<int>>lv(n,vector<int>(m, 0));
    level = lv;

    for (auto& row : lv) {
        row.clear(); // Clear each row
    }
    lv.clear(); // Clear the main vector
    lv.shrink_to_fit(); // Release the allocated memory

    vector<vector<pir>>prnt(n,vector<pir>(m, {-1,-1}));
    parent = prnt;

    for (auto& row : prnt) {
        row.clear(); // Clear each row
    }
    prnt.clear(); // Clear the main vector
    prnt.shrink_to_fit(); // Release the allocated memory

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
    bfs(A);
    if(level[B.first][B.second] == 0)
        cout<<"NO";
    else{
        vector<pir>rode;
        cout<<"YES"<<endl;
        pir current = B;
        while (current != parent[A.first][A.second])
        {
            rode.push_back(current);
            current=parent[current.first][current.second];
        }
        reverse(rode.begin(), rode.end());
        cout<<rode.size()-1<<endl;
        for(int i =1; i<rode.size(); i++)
        {
            if(rode[i-1].first==rode[i].first) // (Parent_i == Child_i) mean same row
            {
                if(rode[i-1].second == rode[i].second-1) // (p_i == C_i-1) mean right
                    cout<<"R";
                else cout<<"L"; // Otherwise Left
            }
            else{
                if(rode[i-1].first == rode[i].first-1) // (P_i == C_i-1) thats mean down
                    cout<<"D";
                else cout<<"U"; // Otherwise Right

            }
        }
    }

return 0;
}