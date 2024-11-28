// if we get any value in Distance[i][i] != 0; that's mean cycle detected.
// because from sorce to sorce to visit we don't need any positive/negitive weight.

// undirected possible for non_negitive Weight.
// and for directed requere non-negitive weighted cycle.

#include<bits/stdc++.h>
using namespace std;

typedef pair<int,int>pir;

int n,m;
vector<vector<int>>Dist;

// remamber it's work for (when start node from 0).
void floyed_warshall() // O(N^3)s.
{   
	for(int k=0; k<n;k++) 
	{
		for(int i =0; i<n; i++) 
		{
            for(int j =0; j<n; j++)
            {
                long long int u = Dist[i][j];
                long long int v1 = Dist[i][k];
                long long int v2 = Dist[k][j];
                long long int x = v1+v2;
                // remember it "if we don't convert it int to long int we get wrong ans because v1+v2 greater then INT_MAX".
               if( u > x) // fast way
               {
                    Dist[i][j] = v1+v2;
               }
            //    Dist[i][j] = min(u , x); // second way
            // if( Dist[i][k] < INT_MAX && Dist[k][j] < INT_MAX && Dist[i][j] > Dist[i][k]+Dist[k][j]){//3rd way.

            // }
            }
		}
	}
}
bool cycleDetected(vector<vector<int>> distance)
{
    for(int i =0; i<n; i++)
    {
        if(distance[i][i] != 0) return true;
    }
    return false;
}
void print_grap()
{
    for(int i =0; i<n; i++)
    {
        for(int j =0; j<n; j++)
        {
            if(Dist[i][j]==INT_MAX)
            {
                cout<<"x"<<" ";
            }
            else{
                cout<<Dist[i][j]<<" ";
            }
        }
        cout<<endl;
    }
}
int main(){

    cin>>n>>m;
    Dist.resize(n);
    for(int i =0; i<n; i++)
    {
        Dist[i].resize(n);
        for(int j =0; j<n; j++)
        {
            if(i==j)
                Dist[i][j] = 0;
            else {
                Dist[i][j] = INT_MAX;
            }
        }
    }
    while(m--)
    {
        int a,b,w;
        cin>>a>>b>>w;
        Dist[a][b] = w;
        // Dist[b][a] = w; // undirected possible for non_negitive Weighted. and for directed requere non-negitive weighted cycle.
    }
    int s,d;
    cin>>s>>d;
    print_grap();
    cout<<"after Floyed Warshall :"<<endl;
    floyed_warshall();
    print_grap();
    if(cycleDetected(Dist)) cout<<"cycle Detected"<<endl;
    else cout<<"cycle dose not detected";
    return 0;
}
