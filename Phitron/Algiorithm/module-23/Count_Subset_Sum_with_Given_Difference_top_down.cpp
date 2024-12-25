//  s1 + s2 = s
//  s1 - s2 = t
//  ---------------
//  2(s1) = s+t
//  s1 = (s+t)/2  // if we can make s1 that's mean ans is true. the question is want ans cout so we should return how many time we can make 's1'.


// 2nd way (not sure).
// (s-t)/2 = s1


#include<bits/stdc++.h>
using namespace std;
int dp[1000][1000];
int difference(int arr[], int n, int s)
{
    if(n==0){
        if(s==0)
            return 1;
        else return 0;
    }
    if(dp[n][s] != -1) return dp[n][s];
    if(arr[n-1] <= s){
        int a = difference(arr,n-1,s-arr[n-1]);
        int b = difference(arr,n-1,s);
        return dp[n][s] = a+b;
    }
    else{
        return dp[n][s] = difference(arr,n-1,s);
    }
}
int main(){

    int n;
    cin>>n;
    int arr[n];
    int s=0;
    for(int i =0; i<n; i++)
    {
        cin>>arr[i];
        s+=arr[i];
    }
    int t;
    cin>>t;
    int x = (s+t)/2;
    for(int i =0; i<=n; i++)
    {
        for(int j =0; j<=x+1; j++)
            dp[i][j] = -1;
    }
    if((s+t)%2==0){
        cout<<difference(arr,n,x)<<endl;
    }
    else cout<<"0"<<endl;

return 0;
}