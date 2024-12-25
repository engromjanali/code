// we can take a value for multiple time that's mean unbounted.
#include<bits/stdc++.h>
using namespace std;
int dp[1001][1001];
int unbounted_knapsack(int n, int s, int arr[], int weight[]){
    if(n==0 || s==0) return 0;
    if(dp[n][s] != -1) return dp[n][s];
    if(weight[n-1] <= s){
        int a = unbounted_knapsack(n,s-weight[n-1],arr,weight)+ arr[n-1];
        int b = unbounted_knapsack(n-1,s,arr,weight);
        return dp[n][s] = max(a,b);
    }
    else return dp[n][s] = unbounted_knapsack(n-1,s,arr,weight);
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
    cout<<unbounted_knapsack(n,s,arr,weight)<<endl;

return 0;
}