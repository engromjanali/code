#include<bits/stdc++.h>
using namespace std;

int parent[]={-1,-1,1,2,1,-1,5,5,5,7};

int dsu_find(int s)
{
    int current= s;
    while (-1 != parent[current])
    {
        current = parent[current];
    }
    return current;
}
int main(){
    int leader;
    leader = dsu_find(9);
    cout<<leader;
return 0;
}