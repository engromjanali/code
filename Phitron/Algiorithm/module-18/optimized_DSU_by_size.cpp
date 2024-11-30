#include<bits/stdc++.h>
using namespace std;

vector<int>parent; //initial value -1
vector<int>SIZE;  // initial value 1
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
    int leader;
    leader = dsu_find(9);
    cout<<leader<<endl;
    dsu_union(1,8);
    cout<<dsu_find(9)<<endl;
return 0;
}