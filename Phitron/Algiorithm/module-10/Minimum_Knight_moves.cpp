#include<bits/stdc++.h>
using namespace std;

typedef pair<int,int> pir;

vector<pir>path={{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
vector<vector<bool>>visited(8,vector<bool>(8,false));
vector<vector<int>>level(8,vector<int>(8,0));

bool isValid(pir p)
{
    return (p.first>= 0 && p.second>=0 && p.first<8 && p.second<8);
}

void bfs(pir u)
{
    queue<pir>q;
    q.push(u);
    visited[u.first][u.second] = true;
    while (!q.empty())
    {
        pir v = q.front();
        q.pop();
        for(pir x : path)
        {
            pir xx = {x.first+v.first, x.second+v.second};
            if( !isValid(xx) || visited[xx.first][xx.second]) continue;
            q.push(xx);
            visited[xx.first][xx.second] = true;
            level[xx.first][xx.second] = level[v.first][v.second] + 1;
        }

    }
    
}

int main(){

    int t;
    cin>>t;
    while (t--)
    {
        for(int i =0; i<8; i++)
        {
            for(int j =0; j<8; j++)
            {
                visited[i][j] = false;
            }
        }

        for(int i =0; i<8; i++)
        {
            for(int j =0; j<8; j++)
            {
                level[i][j] = 0;
            }
        }

        string a,b;
        cin>>a>>b;
        pir A = {a[0]-'a' , a[1]-48-1};
        pir B = {b[0]-'a' , b[1]-48-1};
        bfs(A);
        cout<<level[B.first][B.second]<<endl;
    }
    

return 0;
}