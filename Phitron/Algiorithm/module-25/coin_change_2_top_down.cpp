// we can take a value for multiple time that's mean unbounted.
#include<bits/stdc++.h>
using namespace std;
int dp[1001][1001];

int unbounted_knapsack(int n, int s, int arr[]){
    if(n==0){
        if(s==0)
            return 0;
        else return (INT_MAX-1); // we should use INT-MAX-1 because if we add 1 with INT_MAX we get garbage or negitive value.
    } 
    if(dp[n][s] != -1) return dp[n][s];
    if(arr[n-1] <= s){
        int a = unbounted_knapsack(n,s-arr[n-1],arr)+ 1;// +1 because if we take any value we has used 1 coin.
        int b = unbounted_knapsack(n-1,s,arr);
        return dp[n][s] = min(a,b);
    }
    else return dp[n][s] = unbounted_knapsack(n-1,s,arr);
}

int main(){
 
    int n,s;
    cin>>n>>s;
    int arr[n];
    int weight[n];
    for(int i =0; i<n; i++)
    {
        cin >> arr[i];
    }
    for(int i =0; i<n; i++)
    {
        cin>>weight[i];
    }
    for(int i =0; i<=n; i++){
        for(int j =0; j<=s; j++)
        {
            dp[i][j] = -1;
        }
    }
    cout<<unbounted_knapsack(n,s,arr)<<endl;

return 0;
}