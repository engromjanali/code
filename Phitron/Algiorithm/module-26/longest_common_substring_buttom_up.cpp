#include<bits/stdc++.h>
using namespace std;
int dp[1004][1005];
int main(){

    string a,b;
    cin>>a>>b;
    int n = a.size();
    int m = b.size();
    for(int i =0; i<=n; i++)
    {
        for(int j =0; j<=m; j++){
            if(i==0 || j ==0) dp[i][j] = 0;
        }
    }
    for(int i =1; i<=n; i++)
    {
        for(int j =1; j<=m; j++){
            if(a[i-1] == b [ j-1]){
                dp[i][j] = dp[i-1][j-1]+1;
            }
            else{
                dp[i][j] = 0;
            }
        }
    }
    int max = 0;
    int p , q;
    for(int i =1; i<=n; i++)
    {
        for(int j =1; j<=m; j++){
            if(dp[i][j]>max)
            {
                max= dp[i][j];
                p = i;
                q = j;
            }
        }
    }
    string res="";
    while(p != 0 && q != 0){
        if(a[p-1] == b[q-1])
        {
            res+=a[p-1];
            p--;
            q--;
        }
        else{
            break;
        }
    }
    
    cout<<max<<endl;
    reverse(res.begin(), res.end());
    cout<<res<<endl;
return 0;
}

