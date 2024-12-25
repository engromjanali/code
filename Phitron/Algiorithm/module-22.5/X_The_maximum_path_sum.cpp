// https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/X

#include<bits/stdc++.h>
using namespace std;
vector<vector<int>>dp;
int top_down(vector<vector<int>>&arr, int a, int b)
{
    if(a <0||b<0) return 0;
    if(dp[a][b] != -1) return dp[a][b];

    int op1 = top_down(arr, a, b-1)+arr[a][b];
    int op2 = top_down(arr, a-1, b)+arr[a][b];

    return dp[a][b] = max(op1, op2);
}
int main(){
    

    int n,m;
    cin>>n>>m;
    vector<vector<int>>arr(n,vector<int>(m));
    dp.resize(n,vector<int>(m, -1));
    for(int i =0; i<n; i++)
    {
        for(int j =0; j<m; j++)
        {
            cin>>arr[i][j];
        }
    }
    cout<<top_down(arr,n-1,m-1)<<endl;
return 0;
}