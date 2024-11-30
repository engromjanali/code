
//https://codeforces.com/contest/2034/problem/C
#include<bits/stdc++.h>
using namespace std;
vector<string>grap;
vector<vector<bool>>visited;
vector<vector<pair<int,int>>>parent;
vector<pair<int,int>>path={{0,-1},{0,1},{-1,0},{1,0}};//L-R-U-D
int max_cmp = 0;
bool isValid(pair<int,int> p)
{
    return (p.first>=0 && p.second>=0 && p.first<grap.size() && p.second<grap[0].size());
}
// void dfs(pair<int,int>s)
// {
//     visited[s.first][s.second]= true;
//     max_cmp ++;
//     // cout<<s.first<<s.second<<endl;
//     for(pair<int,int> x: path){
//         pair<int,int> v = {x.first+s.first , x.second+s.second};
//         if(!isValid(v) || visited[v.first][v.second] == true) continue;
//         {
//             parent[v.first][v.second] = {s.first, s.second};
//             dfs(v);

//         }
//     }
// }

int push_on(pair<int,int> s)
{
    int res =0;
    visited[s.first][s.second] = true;
    char c = grap[s.first][s.second];

    if(c=='L')
    {
        pair<int,int>v=make_pair(s.first+path[0].first , s.second+path[0].second);
        if(!isValid(v)) return 0;
            if(visited[v.first][v.second]) return 1;
            int temp = push_on(v);
            if(temp !=0)
                res += temp+=1;
            
    }
    
    else if(c=='R')
    {
        pair<int,int>v=make_pair(s.first+path[1].first , s.second+path[1].second);
        if(!isValid(v)) return 0;
            if(visited[v.first][v.second]) return 1;
            int temp = push_on(v);
            if(temp !=0)
                res += temp+=1;
            
    }
    else if(c=='U')
    {
        pair<int,int>v=make_pair(s.first+path[2].first , s.second+path[2].second);
        if(!isValid(v)) return 0;
            if(visited[v.first][v.second]) return 1;
            int temp = push_on(v);
            if(temp !=0)
                res += temp+=1;
            
    }
    else if(c=='D')
    {
        pair<int,int>v=make_pair(s.first+path[3].first , s.second+path[3].second);
        if(!isValid(v)) return 0;
            if(visited[v.first][v.second]) return 1;
            int temp = push_on(v);
            if(temp !=0)
                res += temp+=1;
            
    }
    return res;
}

void set_grap(int n,int m) // we just work here only. "?" the rome have to set.
{

    for(int i =0; i<n; i++)
    {
        for(int j =0; j<m; j++)
        {
            char c = grap[i][j];
            if(c!='?') continue;
            if(c=='?') {
                {
                    pair<int,int> x1 = path[0];//l
                    pair<int,int> x2 = path[1];//r
                    pair<int,int> x3 = path[2];//u
                    pair<int,int> x4 = path[3];//d
                    pair<int,int>u1 ={x1.first+i , x1.second+j};
                    pair<int,int>u2 ={x2.first+i , x2.second+j};
                    pair<int,int>u3 ={x3.first+i , x3.second+j};
                    pair<int,int>u4 ={x4.first+i , x4.second+j};
                    
                    if(isValid(u1) && grap[u1.first][u1.second] == 'R'){
                        grap[i][j]='L';
                    }
                    
                    else if(isValid(u2) && grap[u2.first][u2.second] == 'L'){
                        grap[i][j]='R';
                        // cout<<"fds";
                    }
                    
                    else if(isValid(u3) && grap[u3.first][u3.second] == 'D'){
                        grap[i][j]='U';
                    }
                    
                    else if(isValid(u4) && grap[u4.first][u4.second] == 'U'){
                        grap[i][j]='D';
                    }
                    else{
                        if(isValid(u1)){
                            grap[i][j]='L';
                            // cout<<grap[u2.first][u2.second]<<" ";
                        }
                        
                        else if(isValid(u2)){
                            grap[i][j]='R';
                        }
                        
                        else if(isValid(u3)){
                            grap[i][j]='U';
                        }
                        
                        else if(isValid(u4)){
                            grap[i][j]='D';
                        }
                    }
                    
                }
            }
        }
    }
}
void get_grap(int n,int m)
{

    for(int i =0; i<n; i++)
    {
        for(int j =0; j<m; j++)
        {
            char c = grap[i][j];
            cout<<c<<" ";
        }
        cout<<endl;
    }
    cout<<endl;
}
int main(){

    int t; cin>>t;
    while(t--)
    {
        grap.clear();
        max_cmp = 0;
        int n,m;
        cin>>n>>m;
        visited.resize(n,vector<bool>(m,false));
        for(int i =0; i<n; i++)
        {
            string s;
            cin>>s;
            grap.push_back(s);
        }
        set_grap(n,m);
        get_grap(n,m);
        for(int i =0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(visited[i][j]) continue;
                max_cmp = max(max_cmp , push_on({i,j}));
                cout<<push_on({i,j})<<endl;
            }
        }
        cout<<max_cmp<<endl;
    }

return 0;
}