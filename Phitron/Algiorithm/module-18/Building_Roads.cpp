//https://cses.fi/problemset/task/1666
#include<bits/stdc++.h>
using namespace std;

vector<int>parent;
vector<int>SIZE;
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
        }
        else{
            parent[leaderA] = leaderB;// new leader B.
            SIZE[leaderB] += SIZE[leaderA]; //leader of size increment.
        }
    }
}
int main(){

    int n,m;
    cin>>n>>m;
    parent.resize(n+1,-1);
    SIZE.resize(n+1, 1);
    while ((m--))
    {
        int a ,b;
        cin>>a>>b;
        int parentA = dsu_find(a);
        int parentB = dsu_find(b);
        if(parentA != parentB)
        {
            dsu_union(parentA,parentB);
        }
    }
    map<int,bool>mp;
    for(int i =1; i<=n; i++)
    {
        int prnt  = dsu_find(i);
        mp.insert({prnt,true});
    }
    vector<int>v;
    for(pair<int,bool> p : mp)
    {
        v.push_back(p.first);
    }
    cout<<v.size()-1<<endl;
    for(int i =1; i<v.size(); i++)
    {
        cout<<v[i-1]<<" "<<v[i]<<endl;
    }

return 0;
}