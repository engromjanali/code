//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int dp[1001][1001];
    int unbounted_knapsack(vector<int>&v, vector<int>&w, int n, int s){
        if(n==0 || s==0) return 0;
        // if(dp[n][s] != -1) return dp[n][s];
        if(w[n-1]<= s){
            int a = unbounted_knapsack(v,w,n,s-w[n-1])+v[n-1];
            int b = unbounted_knapsack(v,w,n-1,s);
            return dp[n][s] = max(a,b);
        }
        else{
            return dp[n][s] = unbounted_knapsack(v,w,n-1,s);
        }
    }
    int knapSack(vector<int>& v, vector<int>& w, int s) {
        // code here
        int n = v.size();
        for(int i =0; i<=s; i++){
            dp[0][i] = 0;
            // for(int j =0; j<=s; j++)
            // {
            //     // dp[i][j] = -1;
            // }
        }
        for(int i =1; i<=n; i++)
        {
            for(int j =0; j<=s; j++)
            {
            if(w[i-1]<= j){
                int a = (dp[i][j-w[i-1]]) + v[i-1];
                int b = dp[i-1][j];
             dp[i][j] = max(a,b);
            }
            else{
                dp[i][j] = dp[i-1][j];   
            }
            }
        }

        return dp[n][s];
        // return unbounted_knapsack(val,wt,n,s);
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int W;
        cin >> W;
        cin.ignore();
        string str;
        getline(cin, str);
        stringstream ss(str);
        vector<int> val;
        int num;
        while (ss >> num) {
            val.push_back(num);
        }
        string str2;
        getline(cin, str2);
        stringstream ss2(str2);
        vector<int> wt;
        int num2;
        while (ss2 >> num2) {
            wt.push_back(num2);
        }
        Solution ob;
        cout << ob.knapSack(val, wt, W) << endl;
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends