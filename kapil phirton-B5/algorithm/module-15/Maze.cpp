// https://www.hackerrank.com/contests/assignment-02-a-introduction-to-algorithms-a-batch-05/challenges/maze-19

#include<bits/stdc++.h>
using namespace std;
typedef pair<int,int> pir;
int n ,m;
pir R,D;
char grap [1000][1000];
int dp [1000][1000] ;
int visited [1000][1000] ;
pir parent [1000][1000] ;
pir path[] = {{0,1},{0,-1},{-1,0},{1,0}};

bool isValid(pir p)
{
    return (p.first>=0 && p.first<n && p.second>=0 && p.second<m);
}
void bfs(pir s)
{
    queue<pir>q;
    q.push(s);
    visited[s.first][s.second]=true;
    while (!q.empty())
    {
        pir v = q.front();
        q.pop();
        for(pir x : path)
        {
            x.first += v.first;
            x.second += v.second;
            if((!isValid(x)) || visited[x.first][x.second] || grap[x.first][x.second]=='#') continue;
            q.push(x);
            visited[x.first][x.second] = true;
            parent[x.first][x.second] = v;
        }
    }
}


int main(){

    cin>>n>>m;
    for(int i =0; i<n; i++)
    {
        for(int j =0; j<m; j++)
        {
            cin>>grap[i][j];
            if(grap[i][j]=='R'){
                R.first =i;
                R.second= j;
            }
            if(grap[i][j]=='D'){
                D.first =i;
                D.second= j;
            }
        }
    }
    for(int i =0; i<n; i++)
    {
        for(int j =0; j<m; j++)
        {
            dp[i][j]=-1;
            visited[i][j] =0;
        }
    }
    bfs(R);
    if(visited[D.first][D.second]){
        pir p = {0,0};
        pir current = parent[D.first][D.second];
        while(parent[current.first][current.second]!=p)
        {
            // cout<<current.first<<" "<<current.second<<endl;
            grap[current.first][current.second] ='X';
            current = parent[current.first][current.second];
        }
        for(int i =0; i<n; i++)
        {
            for(int j =0; j<m; j++)
            {
                cout<<grap[i][j];
            }
            cout<<endl;
        }
    }  
    else{
        for(int i =0; i<n; i++)
        {
            for(int j =0; j<m; j++)
            {
                cout<<grap[i][j];
            }
            cout<<endl;
        }
    }
return 0;
}