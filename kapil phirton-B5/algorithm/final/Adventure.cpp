#include<bits/stdc++.h>
using namespace std;
int dp[1001][1001];
int top_down(int arr[],int val[], int n, int s){
    if(n<1 || s<1) return 0;
    if(dp[n][s] != -1) return dp[n][s];
    if(arr[n-1] <= s){
        int a= top_down(arr,val,n-1,s-arr[n-1])+val[n-1];
        int b= top_down(arr,val,n-1,s);
        return dp[n][s] = max(a,b);
    }
    else return dp[n][s] = top_down(arr,val,n-1,s);
}
int main(){

    int t;
    cin>>t;
    while ((t--))
    {
        int n,s;
        cin>>n>>s;
        int arr[n];
        int val[n];
        for(int i =0; i<n; i++)
        {
            cin>>arr[i];
        }
        for(int i =0; i<n; i++)
        {
            cin>>val[i];
        }
        for(int i =0; i<=n; i++)
        {
            for(int j =0; j<=s; j++)
            {
                dp[i][j] =-1;
            }
        }
        cout<<top_down(arr,val,n,s)<<endl;
    }
    

return 0;
}