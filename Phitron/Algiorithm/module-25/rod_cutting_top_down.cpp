#include<bits/stdc++.h>
using namespace std;
int dp[10000][10000];
int top_down(int n, int s, int arr[], int weight[]){
    if(n==0)
    {
        return 0;
    }
    if(dp[n][s] != -1) return dp[n][s];
    if(weight[n-1] <=s){
        int a = top_down(n,s,arr,weight)+arr[n-1];
        int b = top_down(n-1,s,arr,weight);
        return dp[n][s] = max(a,b);
    }
    else{
        return dp[n][s] = top_down(n-1,s,arr,weight);
    }
}
int main(){

    int n;
    cin>>n;    
    int value[n];
    int weight[n];
    for (int i =0; i<n; i++)
    {
        cin>>value[i];
        weight[i] =i+1; 
    }
    
    for(int i =0; i<=n; i++)
    {
        for(int j=0; j<=n; j++)
        {
            if(i==0)
                dp[i][j] =0;
        }
    }
    // dp[0][0] = 1;
    
    for(int i =1; i<=n; i++)
    {
        for(int j =0; j<= n; j++)
        {
            if(j>=weight[i-1])
            {
                int op1 = (dp[i][j-weight[i-1]]) + value[i-1];
                int op2 = (dp[i-1][j]);
                dp[i][j] = max(op1 , op2);
            }
            else {
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    
    cout<<top_down(n,n,value,weight)<<endl;
return 0;
}