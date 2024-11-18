// direct and un-direct
#include<bits/stdc++.h>
using namespace std;

int main(){

    int n,m;
    cin>>n>>m;
    vector<vector<pair<int,int>>>grap(n);  // standrd we should not track anything.    

    // input
    while (m--)
    {
        int u,v,w;
        cin>>u>>v>>w;

        grap[u-1].push_back({v,w}); // for direct
        // grap[v-1].push_back({u,w}); // for un-direct
    }

    // output
    for(int i =0; i < grap.size();i++)
    {
        for(int j =0; j<grap[i].size(); j++)
        {
            cout<<"{"<<grap[i][j].first<<" , "<<grap[i][j].second<<"}"<<" ";
        }
        cout<<endl;
    }
return 0;
}