#include<bits/stdc++.h>
using namespace std;
int dp[10000][10000];
int top_down(int n, int s, int arr[]){
    if(n==0){
        if(s==0)return 0;
        else return INT_MAX-1;
    }
    if(dp[n][s] != -1) return dp[n][s];
    if(arr[n-1] <= s){
        int a= top_down(n,s-arr[n-1],arr)+ 1;
        int b= top_down(n-1,s,arr);
        return dp[n][s] = min(a,b);
    }
    else{
        return dp[n][s] = top_down(n-1,s,arr);
    }
}
int main(){

    int n,s;
    cin>>n>>s;    
    int value[n];
    for (int i =0; i<n; i++)
    {
        cin>>value[i];
    }
    
    for(int i =0; i<=n; i++)
    {
        for(int j=0; j<=s; j++)
        {
                dp[i][j] =-1;
        }
    }
    // dp[0][0] = 1;
    for(int i =0; i<=n; i++)
    {
        for(int j=0; j<=s; j++)
        {
                cout<<dp[i][j]<<" ";
        }
        cout<<endl;
    }
    
    
    for(int i =0; i<=n; i++)
    {
        for(int j=0; j<=s; j++)
        {
                cout<<dp[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<top_down(n,s,value)<<endl;
return 0;
}