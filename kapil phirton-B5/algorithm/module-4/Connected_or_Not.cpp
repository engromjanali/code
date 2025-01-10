#include<bits/stdc++.h>
using namespace std;
int adj_matrix[1001][1001];
int main(){

    int n, m; 
    cin>>n>>m;
    for(int i =0; i<n; i++)
    {
        for(int j =0; j<n; j++)
        {
            adj_matrix[i][j] =0;
        }
    }
    for(int i =0; i<m; i++)
    {
        int a,b;
        cin>>a>>b;
        adj_matrix[a][b]=1;
    }

    int q; cin>>q;
    while (q--)
    {
        int a,b; cin>>a>>b;
        if(adj_matrix[a][b]==1 || a==b) cout<<"YES"<<endl;
        else cout<<"NO"<<endl;
    }
    
return 0;
}