// direct and un-direct
#include<bits/stdc++.h>
using namespace std;

int main(){

    int n, m;
    cin>>n>>m;
    int grap[n][n]={};// for every value 0. // 2nd way: to make every value 0. we have to all value of fast row. then other all value will be 0.
    //input
    for(int i=0; i<m; i++)
    {
        int u,v;
        cin>>u>>v;
        grap[u-1][v-1] = 1;// for adjacency direct
        grap[v-1][u-1] = 1;// for adjacency un-direct
    }
    // output.
    for(int i =0; i<n; i++)
    {
        for( int j = 0; j<n; j++)
        {
            cout<<grap[i][j] << " ";
        }
        cout<<endl;
    }

return 0;
}