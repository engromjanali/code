//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
// https://www.geeksforgeeks.org/problems/coin-change2448/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    int count(vector<int>& value, int s) {
        // code here.
        int n = value.size();
        int dp[n+1][s+1];
        
        for(int j=0; j<=s; j++)
        {
            dp[0][j] =0;
        }
    dp[0][0] = 1;

    
    for(int i =1; i<=n; i++)
    {
        for(int j =0; j<= s; j++)
        {
            if(j>=value[i-1])
            {
                int op1 = (dp[i][j-value[i-1]]);
                int op2 = (dp[i-1][j]);
                dp[i][j] = (op1 + op2);
            }
            else {
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    return dp[n][s];
    }
};

//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        int sum;
        cin >> sum;
        cin.ignore();
        Solution ob;
        cout << ob.count(arr, sum) << endl;
        cout << "~" << endl;
    }

    return 0;
}

// } Driver Code Ends