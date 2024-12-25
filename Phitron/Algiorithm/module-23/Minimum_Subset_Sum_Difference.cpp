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

        bool dp[n+1][s+1];
        for(int i =1; i<=s; i++){
            dp[0][i] = false;
        }
        dp[0][0] = true;

        for(int i =1; i<=n; i++)
        {
            for(int j =0; j<=s; j++)
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
        vector<int>v;
        for(int i = 0; i<=n; i++)
        {
            for(int j =0; j<=s; j++)
            {
                if(dp[i][j])
                {
                    v.push_back(j);
                }
            }
        }
        int ans  = INT_MAX;
        for(int x : v)
        {
            int x2 = s-x;
            ans = min(ans, abs(x-x2));
        }
        cout<<ans<<endl;
         
    
return 0;
}