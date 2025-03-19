#include<bits/stdc++.h>
using namespace std;
int arr[1001];
int dp[1001][2001];
bool top_down(int arr[], int n, int s){
    if(n==0){
        if(s==0) return true;
        else return false; 
    }
    if(dp[n][s] != -1) return dp[n][s];
    if(arr[n-1]<= s){
        return dp[n][s] = (top_down(arr,n-1,s-arr[n-1]) || top_down(arr,n-1,s));
    }
    else return dp[n][s] = top_down(arr, n-1,s);
}

int main(){

    int t; cin>>t;
    while(t--)
    {
        int s  = 1000;
        int n ;cin>>n;
        int sum=0;
        int x ; cin>>x;
        s = s-x;
        for(int i =0; i<n; i++)
        {
            cin>>arr[i];
        }
        for(int i =0; i<=n; i++)
        {
            for(int j =0; j<=s; j++){
                dp[i][j] = -1;
            }
        }
        if(top_down(arr,n,s))
            cout<<"YES"<<endl;
        else cout<<"NO"<<endl;
    }
return 0;
}