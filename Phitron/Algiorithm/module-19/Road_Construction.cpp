// https://cses.fi/problemset/task/1676/
#include<bits/stdc++.h>
using namespace std;

vector<int>parent;
vector<int>SIZE;
int max_component = 0;
int dsu_find(int s)
{
    int current= s;
    while (-1 != parent[current])
    {
        current = parent[current];
    }
    return current;
}

void dsu_union(int a, int b) //optimized
{
    int leaderA = dsu_find(a);
    int leaderB = dsu_find(b);
    
    if(leaderA != leaderB)
    {
        int sizeA = SIZE[leaderA];
        int sizeB = SIZE[leaderB];

        if(sizeA > sizeB)
        {
            parent[leaderB] = leaderA;// new leader A.
            SIZE[leaderA] += SIZE[leaderB]; //leader of size increment.
            max_component= max(max_component,SIZE[leaderA]);
        }
        else{
            parent[leaderA] = leaderB;// new leader B.
            SIZE[leaderB] += SIZE[leaderA]; //leader of size increment.
            max_component= max(max_component,SIZE[leaderB]);
        }
    }
}

int main(){

    int n,m;
    cin>>n>>m;
    
    parent.resize(n+1, -1);
    SIZE.resize(n+1, 1);
    int cmp=n;
    while (m--)
    {
        int a,b;
        cin>>a>>b;
        int leaderA = dsu_find(a);
        int leaderB = dsu_find(b);
        if(leaderA != leaderB)
        {
            cmp--;
            dsu_union(leaderA, leaderB);
        }
        cout<<cmp<<" "<<max_component<<endl;
    }
return 0;
}