//https://codeforces.com/contest/2034/problem/C
#include<bits/stdc++.h>
using namespace std; 
typedef pair<int,int> pir;
 
vector<string>grap;
vector<vector<bool>>visited;
vector<vector<int>>record;

vector<char>derection={'L','R','U','D'};

vector<pair<int,int>>path={{0,-1},{0,1},{-1,0},{1,0}};//L-R-U-D
bool isValid(pair<int,int> p)
{
    return (p.first>=0 && p.second>=0 && p.first<grap.size() && p.second<grap[0].size());
}

// here we are getting sur future rode are locked or unlocked.
bool dfs(pir s)
{
    bool res = false;

    if(!isValid(s)) return false;

    if(record[s.first][s.second] == 1) return true; // if record ==1 that's mean the room are true/loced.
    else if(record[s.first][s.second] == 0) return false; // if recoed ==0 that's mean unlocked and -1 mean we did not know. it's initial valiue.
    
    // cout<<grap[s.first][s.second];
    if(visited[s.first][s.second]){
        record [s.first][s.second] = 1;
        return true;
    } 
    visited[s.first][s.second]= true;
    if(grap[s.first][s.second] == '?') 
    {
        record [s.first][s.second] = 1;
        return true;
    }
    for(int i =0; i<4; i++)
    {
        if(grap[s.first][s.second] == derection[i])
        {
            res = dfs({s.first+path[i].first , s.second+path[i].second});
            break;
        } 
    }
    if(res)
        record[s.first][s.second] = 1;
    else record[s.first][s.second] = 0;
    return res;
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
        // input sagments
        grap.clear();
        visited.clear();
        record.clear();
        int n,m;
        cin>>n>>m;
        visited.resize(n,vector<bool>(m,false));
        record.resize(n,vector<int>(m,-1));
        for(int i =0; i<n; i++)
        {
            string s;
            cin>>s;
            grap.push_back(s);
        }
        
        // filling empty direction.
        for(int i =0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grap[i][j] != '?') continue;
                for(int k =0; k<4; k++)
                {
                    visited.clear();
                    visited.resize(n,vector<bool>(m,false));
                    pir v = {i+path[k].first  , j+path[k].second};
                    if(dfs(v)) {                        
                        grap[i][j] = derection[k];
                        break;
                    }    
                }
                if(grap[i][j]=='?') grap[i][j] = 'D'; // if we get any room with "?" like that. and if we can set any but we can't lock him. when we set a random derection here. we can ignore it also.
            }
        }

        // get_grap(n,m);
        
        // here we r chacking how many room are locked.
        int ans =0;
        for(int i =0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                visited.clear();
                visited.resize(n,vector<bool>(m,false));
                if(dfs({i,j}))
                {
                ans++;   
                } 
            }
        }
        //here showing result
        cout<<ans<<endl;
    }
return 0;
}



// #include <bits/stdc++.h>

// using namespace std;

// #define fastIO                                                                 \
//     ios::sync_with_stdio(false);                                               \
//     cin.tie(NULL);                                                             \
//     cout.tie(NULL);                                                            \
//     cout.precision(numeric_limits<double>::max_digits10);


// void CoderAbhi27() {
//     int n, m;
//     cin >> n >> m;
//     vector<string> a(n);
//     for (int i = 0; i < n; i++) {
//         cin >> a[i];
//     }

//     if (n == 1 && m == 1) {
//         cout << "0\n";
//         return;
//     }

//     queue<pair<int, int>> q;
//     vector<vector<int>> vis(n, vector<int>(m, 0));
//     for (int i = 0; i < n; i++) {
//         for (int j = 0; j < m; j++) {
//             if ((i == 0 && a[i][j] == 'U') || (i == n - 1 && a[i][j] == 'D') ||
//                 (j == 0 && a[i][j] == 'L') || (j == m - 1 && a[i][j] == 'R')) {
//                 q.push({i, j});
//                 vis[i][j] = 1;
//             }
//         }
//     } // n*m

//     while (!q.empty()) {
//         auto [i, j] = q.front();
//         q.pop();

//         if (i - 1 >= 0 && !vis[i - 1][j] && a[i - 1][j] == 'D') {
//             vis[i - 1][j] = 1;
//             q.push({i - 1, j});
//         }
//         if (j - 1 >= 0 && !vis[i][j - 1] && a[i][j - 1] == 'R') {
//             vis[i][j - 1] = 1;
//             q.push({i, j - 1});
//         }
//         if (i + 1 < n && !vis[i + 1][j] && a[i + 1][j] == 'U') {
//             vis[i + 1][j] = 1;
//             q.push({i + 1, j});
//         }
//         if (j + 1 < m && !vis[i][j + 1] && a[i][j + 1] == 'L') {
//             vis[i][j + 1] = 1;
//             q.push({i, j + 1});
//         }

//         auto check = [&](int ii, int jj) {
//             if (ii < 0 || ii >= n || jj < 0 || jj >= m)
//                 return;
//             if (vis[ii][jj] || a[ii][jj] != '?')
//                 return;
//             if (ii - 1 >= 0 && !vis[ii - 1][jj])
//                 return;
//             if (jj - 1 >= 0 && !vis[ii][jj - 1])
//                 return;
//             if (ii + 1 < n && !vis[ii + 1][jj])
//                 return;
//             if (jj + 1 < m && !vis[ii][jj + 1])
//                 return;
//             vis[ii][jj] = 1;
//             // q.push({ii, jj});
//         };

//         check(i - 1, j);
//         check(i + 1, j);
//         check(i, j - 1);
//         check(i, j + 1);
//     } // O(n*m + 4*n*m)

//     int ans = 0;
//     for (int i = 0; i < n; i++)
//         for (int j = 0; j < m; j++)
//             if (vis[i][j] == 0)
//                 ans++;
//     // n*m

//     cout << ans << '\n';
// }

// // tc -> O(n*m)

// int32_t main() {
//     fastIO;

//     int t = 1;
//     cin >> t;
//     while (t--) {
//         CoderAbhi27();
//     }
//     return 0;
// }