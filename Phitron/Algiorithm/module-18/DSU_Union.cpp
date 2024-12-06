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
void dsu_union(int a, int b)// it's not optimized
{
    int leaderA = dsu_find(a);
    int leaderB = dsu_find(b);
    if(leaderA != leaderB)
    {
        parent[leaderB] = leaderA;// new leader A.
    }
}
// void dsu_union(int a, int b)//optimized
// {
//     int leaderA = dsu_find(a);
//     int leaderB = dsu_find(b);
    
//     if(leaderA != leaderB)
//     {
//         int lavelA = level[leaderA];
//         int lavelB = level[leaderB];

//         if(lavelA > lavelB)
//         {
//             parent[leaderB] = leaderA;// new leader A.
//         }
//         else if(lavelA < lavelB){
//             parent[leaderA] = leaderB;// new leader B.
//         }
//         else{
//             parent[leaderB] = leaderA;// new leader A.
//             level[leaderA]++; //leader of lavel increment.
//         }
//     }
// }
int main(){
    int leader;
    leader = dsu_find(9);
    cout<<leader<<endl;
    dsu_union(1,8);
    cout<<dsu_find(9)<<endl;
return 0;
}