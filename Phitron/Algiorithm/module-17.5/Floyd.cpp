#include<bits/stdc++.h>
using namespace std;
int Distance[ 101][101];
void setDistance(int n)
{
    for(int i =1; i<=n; i++)
    {
        for(int j =1; j<=n; j++)
        {
            Distance[i][j] = INT_MAX;
            Distance[i][i] = 0;
        }
    }
}
void getDistance(int n)
{
    for(int i =1; i<=n; i++)
    {
        for(int j =1; j<=n; j++)
        {
            cout<<Distance[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<endl;
}
void floyd_warshall(int n)
{
    for(int k =1; k<=n; k++)
    {
        for(int i =1; i<=n; i++)
        {
            for(int j =1; j<=n; j++)
            {
                if(Distance[i][k]<INT_MAX && Distance[k][j]<INT_MAX && Distance[i][j]> Distance[i][k] + Distance[k][j])
                {
                    Distance[i][j] = Distance[i][k] + Distance[k][j];
                }   
            }
        }
    }
}
int main(){

    int n;
    cin>>n;
    for(int i =1; i<=n; i++)
    {
        for(int j= 1; j<=n; j++)
        {
            int w ;
            cin>>w;
            Distance[i][j] = w;
            if(w==-1) Distance[i][j] = INT_MAX;
        }
    }
    floyd_warshall(n);
    // getDistance(n);
    int max_sortest_distance= INT_MIN;
    for(int i =1; i<=n; i++)
    {
        for(int j =1; j<=n; j++)
        {
            if(Distance[i][j] != INT_MAX)
            {
                max_sortest_distance = max(max_sortest_distance, Distance[i][j]);
            }
        }
    }
    cout<<max_sortest_distance;
return 0;
}
