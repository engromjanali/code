#include<bits/stdc++.h>
using namespace std;

int n,m;
vector<vector<int>>grap;
void floyed_warshall()
{
    for(int k =0; k<n; k++)
    {
        for(int i =0; i<n; i++)
        {
            for(int j =0; j<n; j++)
            {
                long long int w = grap[i][j];
                long long int u = grap[i][k];
                long long int v = grap[k][j];

                grap[i][j] = min(w,u+v);
            }
        }
    }
}
int main(){

    cin>>n>>m;
    grap.resize(n);
    for(int i =0; i<n; i++)
    {
        grap[i].resize(n, INT_MAX);
        grap[i][i] =0;            
    }
    for(int i =0; i<m; i++)
    {
        int a, b, w;
        cin>>a>>b>>w;
        grap[a-1][b-1]=w; //-1 for starting from 1.
    }
    int s;
    cin>>s;
    floyed_warshall();
    int t;
    cin>>t;
    while(t--)
    {
        int d,dw;
        cin>>d>>dw;
        if(d>n) cout<<"NO"<<endl;
        else if(grap[s-1][d-1] <= dw) //-1 for starting from 1.
        {
            cout<<"YES"<<endl;
        }
        else cout<<"NO"<<endl;
    }

return 0;
}