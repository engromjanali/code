//https://www.spoj.com/problems/FARIDA/en/
// like choice 

// buttom up ----------------------------------
// #include<bits/stdc++.h>
// using namespace std;

// int main(){

//     int t;
//     cin>>t;
//     for(int tk =1; tk<=t; tk++){
//         int n;
//         cin>>n;
//         vector<int>arr(n+1,0);
//         for(int i =1; i<=n; i++)
//         {
//             cin>>arr[i];
//         }
//         vector<int>new_arr(n+1);
//         new_arr[0]=0; 
//         new_arr[1]=arr[1];
//         for(int i = 2; i<=n; i++)
//         {
//             int a = new_arr[i-2]+arr[i];
//             int b = new_arr[i-1];
//             new_arr[i] = max(a,b);
//         }
//         cout<<"Case "<<tk<<": "<<new_arr.back()<<endl;    
//     }
// return 0;
// }


// top down ----------------------------------
#include<bits/stdc++.h>
using namespace std;
vector<int>dp;
int top_down(vector<int>&arr, int n)
{
    if(n<1) return 0;
    if(dp[n] != -1) return dp[n];

    int a = top_down(arr,n-1);
    int b = top_down(arr,n-2) + arr[n];
    return dp[n] = max(a,b);
}

int main(){

    int t;
    cin>>t;
    for(int tk =1; tk<=t; tk++){
        int n;
        cin>>n;
        dp.clear();dp.shrink_to_fit(); 
        dp.resize(n+1, -1);
        vector<int>arr(n+1,0);
        for(int i =1; i<=n; i++)
        {
            cin>>arr[i];
        }
        vector<int>new_arr(n+1);
        cout<<"Case "<<tk<<": "<<top_down(arr,n)<<endl;    
    }
return 0;
}