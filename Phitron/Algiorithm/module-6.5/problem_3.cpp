#include<bits/stdc++.h>
using namespace std;

int main(){

    int n,m;
    cin>>n>>m;

    vector<vector<int>>grap(n);
    while(m--)
    {
        int u,v;
        cin>>u>>v;

        grap[u-1].push_back(v);
    }
    int matrix[n][n]={};
    for(int i =0; i<grap.size(); i++)
    {
        for(int x : grap[i])
        {
            matrix[i][x-1] = 1;
        }
    }

    for(int i =0; i<sizeof(matrix)/sizeof(matrix[0]); i++){
        for(int j =0; j<sizeof(matrix[i])/sizeof(matrix[i][0]); j++)
        {
            cout<<matrix[i][j]<<" ";
        }
        cout<<endl;
    }

return 0;
}