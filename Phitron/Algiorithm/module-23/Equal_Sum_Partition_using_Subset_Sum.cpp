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
    if(s%2==0) //  if total sum of set are odd, that's mean it's not possible.
    {
        int t = s/2;
        bool dp[n+1][t+1];
        for(int i =1; i<=t; i++){
            dp[0][i] = false;
        }
        dp[0][0] = true;

        for(int i =1; i<=n; i++)
        {
            for(int j =0; j<=t; j++)
            {
                if(arr[i-1]<=j){
                    bool a = dp[i-1][j-arr[i-1]];
                    bool b = dp[i-1][j];
                    dp[i][j] = a||b;

                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[n][t]) cout<<"YES"<<endl;
        else cout<<"NO"<<endl;
        for(int i = 0; i<=n; i++)
        {
            for(int j =0; j<=t; j++)
            {
                cout<<dp[i][j]<<" ";
            }
                cout<<endl;
        }
    }
    else{
        cout<<"NO"<<endl;
    }
    

return 0;
}