#include<bits/stdc++.h>
using namespace std;
int Distance[101][101];

void setDistance(int n)
{
    for(int i =1; i<=n; i++)
    {
        for(int j = 1; j<=n; j++)
        {
            if(i==j)
            {
                Distance[i][j] = 0;
                continue;
            }
            Distance[i][j] = 30000;
        }
    }
}
void getDistance(int n)
{
    for(int i =1; i<=n; i++)
    {
        for(int j = 1; j<=n; j++)
        {
            cout<<Distance[i][j] << " ";
        }
        cout<<endl;
    }
    cout<<endl;
}
void folyd_warshall(int n)
{
    for(int k =1; k<=n; k++)
    {
        for(int i =1; i<=n; i++)
        {
            for(int j =1; j<=n; j++)
            {
                if(Distance[i][k]<30000 && Distance[k][j]<30000 && Distance[i][j]>Distance[i][k]+Distance[k][j])
                {
                    Distance[i][j] = Distance[i][k] + Distance[k][j];
                }
            }
        }
    }
}
int main(){

    int n,m;
    cin>>n>>m;
    setDistance(n);

    for(int i =1; i<=m; i++)
    {
        int a,b,w;
        cin>>a>>b>>w;
        Distance[a][b] = min(Distance[a][b] , w);
    }
    // getDistance(n);
    folyd_warshall(n);
    // getDistance(n);
    for(int i =1; i<=n; i++)
    {
        cout<<Distance[1][i]<<" ";
    }

return 0;
}