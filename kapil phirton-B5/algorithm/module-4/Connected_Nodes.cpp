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
        adj_matrix[b][a]=1;
    }

    int q; cin>>q;
    while (q--)
    {
        priority_queue<int>pq;
        int f; cin>>f;
        for(int i=0; i<n; i++)
        {
            if(adj_matrix[f][i]==1) pq.push(i);
        }
        if(pq.empty()) cout<<-1;
        while(!pq.empty()){
            cout<<pq.top()<<" ";
            pq.pop();
        }
        cout<<endl;
    }
    
return 0;
}