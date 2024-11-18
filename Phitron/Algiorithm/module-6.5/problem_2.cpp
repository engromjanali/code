#include<bits/stdc++.h>
using namespace std;

int main(){

    int n;
    cin>>n;
    int adj_matrix[n][n]={};

    for(int i =0; i< n; i++)
    {
        for(int j =0; j<n; j++)
        {
            int a;
            cin>>a;
            adj_matrix[i][j] = a;

        }
    }

    vector<vector<int>>grap(n);
    for(int i =0; i<n; i++)
    {
        for(int j =0; j<n; j++)
        {
            if(adj_matrix[i][j] == 1)
            {
                grap[i].push_back(j+1);
            }
        }
    }
    
    for(int i =0; i < grap.size();i++)
    {
        cout<<"List "<<i+1<<" : ";
        for(int j =0; j<grap[i].size(); j++)
        {
            cout<<grap[i][j]<<" ";
        }
        cout<<endl;
    }

return 0;
}