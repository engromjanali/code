// https://www.hackerrank.com/contests/assignment-04-a-introduction-to-algorithms-a-batch-03/challenges/shortest-distance-2/problem#include<bits/stdc++.h>

#include<bits/stdc++.h>
using namespace std;
void floyd_warshall(vector<vector<long long>>&grap)
{
    for(int k =1; k<grap.size(); k++)
    {
        for(int i = 1; i<grap[0].size(); i++)
        {
            for(int j =1; j<grap[0].size(); j++)
            {

                long long w1 = grap[i][k];
                long long w2 = grap[k][j];
                long long w = grap[i][k] + grap[k][j];
                if(w1 == LONG_MAX || w2 == LONG_MAX) continue; // beause if a value has infinity that's mean it's mean here can't possible to reach. if we don't use it we get nearest value of INT_MAX not exitllay INT_MAX because(INT_MAX + -2 == 2147483645).  

                grap[i][j] = min(w , grap[i][j]);
            }
        }
    }
}
void get_grap(vector<vector<long long>>grap)
{
    for(int i =1; i<grap.size(); i++)
    {
        for(int j =1; j<grap.size(); j++)
        {
            if(grap[i][j]==LONG_MAX) cout<<"x ";
            else cout<<grap[i][j]<<" ";
        }
        cout<<endl;
   }
}
int main(){

    int n,m;
    cin>>n>>m;
    vector<vector<long long>>grap(n+1,vector<long long>(n+1,LONG_MAX));
    for(int i =0; i<=n; i++)
        grap[i][i] =0;
    for(int i =0; i<m; i++)
    {
        int a, b, w;
        cin>>a>>b>>w;
        grap[a][b]= min(grap[a][b],(long long)w);
        // grap[b][a]= min(grap[b][a],w);
        
    }
    // get_grap(grap);
    floyd_warshall(grap);
    // get_grap(grap);
    int q; cin>>q;
    while ((q--))
    {
        int s,d;
        cin>>s>>d;
        if(grap[s][d] == LONG_MAX) cout<<"-1"<<endl;
        else cout<<grap[s][d]<<endl;
    }
return 0;
}

