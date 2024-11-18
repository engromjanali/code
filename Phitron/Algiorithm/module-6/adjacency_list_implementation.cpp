// direct and un-direct
#include<bits/stdc++.h>
using namespace std;

int main(){
    int n,m;
    cin>>n>>m;
    vector<vector<int>>grap(n);  // standrd we should not track anything.
    // vector<int>grap[n]; // it's valid also but we have to track "n" for size or number of row. 
    
    // input
    while (m--)
    {
        int u,v;
        cin>>u>>v;

        grap[u-1].push_back(v); // for direct
        // grap[v-1].push_back(u); // for un-direct
    }

    // output
    for(int i =0; i < grap.size();i++)
    {
        for(int j =0; j<grap[i].size(); j++)
        {
            cout<<grap[i][j]<<" ";
        }
        cout<<endl;
    }
return 0;
}