// there are two way to done it.

// way 1 O(M)------------------------------

#include<bits/stdc++.h>
using namespace std;

int main(){

    string a, b;
    cin>>a>>b;
    int i =0;
    bool flag = false;
    for(char x : b){
        if(a[i]==x)i++;
        if(i==a.size()){
            flag = true;
            break;
        }
    }
    if(flag) cout<<"YES"<<endl;
    else cout<<"NO"<<endl;

return 0;
}

//2nd way -O(N*M) ---------------------------

// #include<bits/stdc++.h>
// using namespace std;

// int main(){

//     string a,b;
//     cin>>a>>b;
//     int n,m;
//     n = a.size();
//     m = b.size();
//     int dp[n+1][m+1];
//     for(int i =0; i<=n; i++)
//         dp[i][0]=0;
//     for(int i =0; i<=m; i++)
//         dp[0][i]=0;
//     for(int i =1; i<=n; i++)
//     {
//         for(int j =1; j<=m; j++)
//         {
//             if(a[i-1]==b[j-1]){
//                 dp[i][j] = dp[i-1][j-1] +1;
//             }
//             else{
//                 dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
//             }
//         }
//     }
//     if(dp[n][m] == a.size()){
//         cout<<"YES"<<endl;
//     }
//     else cout<<"NO"<<endl;
// return 0;
// }







