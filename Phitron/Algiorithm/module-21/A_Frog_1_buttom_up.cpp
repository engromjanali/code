// https://atcoder.jp/contests/dp/tasks/dp_a
#include<bits/stdc++.h>
using namespace std;

int main(){

    int n;
    cin>>n;
    int arr[n+1];
    int cost[n+1];
    for(int i=1; i<=n; i++)
    {
        cin>>arr[i];
    }
    cost[1]=0; cost[2]=abs(arr[1]-arr[2]);
    for(int i=3; i<=n; i++)
    {
        int cost1 = abs(arr[i-1]-arr[i]);
        int cost2 = abs(arr[i-2]-arr[i]);

        int current1 = abs(cost1 + cost[i-1]);
        int current2 = abs(cost2 + cost[i-2]);

        cost[i] = min(current1,current2);
    }
    cout<<cost[n];
return 0;
}