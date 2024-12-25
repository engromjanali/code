//  s1 + s2 = s
//  s1 - s2 = t
//  ---------------
//  2(s1) = s+t
//  s1 = (s+t)/2  // if we can make s1 that's mean ans is true. the question is want ans cout so we should return how many time we can make 's1'.

// 2nd way.
// (s-t)/2 = s1

#include<bits/stdc++.h>
using namespace std;

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
    if((s+t)%2==0){
        int x = (s+t)/2;
        int dp[n+1][x+1];
        for(int i =1; i<=x+1; i++){
            dp[0][i] = 0;
        }
        dp[0][0] = 1;
        for(int i =1; i<=n; i++)
        {
            for(int j =0; j<=x+1; j++)
            {
                if(arr[i-1]<=j){
                    int a = dp[i-1][j-arr[i-1]];
                    int b = dp[i-1][j];
                    dp[i][j] = a+b;
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        cout<<dp[n][x];
    }
    else{
        cout<<"0"<<endl;
    }

    // for(int i = 0; i<=n; i++)
    // {
    //     for(int j =0; j<=x; j++)
    //     {
    //         cout<<dp[i][j]<<" ";
    //     }
    // cout<<endl;
    // }
    
return 0;
}