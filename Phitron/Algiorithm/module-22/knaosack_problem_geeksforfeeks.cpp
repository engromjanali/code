// https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // Function to return max value that can be put in knapsack of capacity.
    int knapSack(int capacity, vector<int> &val, vector<int> &wt) {
        // code here
        int n=val.size();
        int s= capacity;
        vector<vector<int>>dp(n+1, vector<int>(s+1,0));        
        // for(int i =0; i<=n; i++)
        // {
        //     for(int j=0; j<=s; j++)
        //     {
        //         if(i==0 || j==0)
        //             dp[i][j] =0;
        //     }
        // }
        
        for(int i =1; i<=n; i++)
        {
            for(int j =1; j<= s; j++)
            {
                if(j>=wt[i-1])
                {
                    int op1 = (dp[i-1][j-wt[i-1]])+ val[i-1];
                    int op2 = (dp[i-1][j]);
                    dp[i][j] = max(op1, op2);
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
    // Taking total test cases
    int testCases;
    cin >> testCases;
    cin.ignore();
    while (testCases--) {
        // Reading number of items and capacity
        int numberOfItems, capacity;
        vector<int> weights, values;
        string input;
        int number;

        // Read capacity and number of items
        getline(cin, input);
        stringstream ss(input);
        ss >> capacity;      // The first number is the capacity
        ss >> numberOfItems; // The second number is the number of items

        // Read values
        getline(cin, input);
        ss.clear();
        ss.str(input);
        while (ss >> number) {
            values.push_back(number);
        }

        // Read weights
        getline(cin, input);
        ss.clear();
        ss.str(input);
        while (ss >> number) {
            weights.push_back(number);
        }

        Solution solution;
        cout << solution.knapSack(capacity, values, weights) << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends


// 2nd way ----------------------

    // Function to return max value that can be put in knapsack of capacity.
    int dp[10000][10000];
    int knapSack(int s, vector<int> &item, vector<int> &weight, int n = 0) {
        // code here
        // cout<<n<<s<<endl;
        if(n<1 || s<1) return 0;
        if(dp[n][s] != -1) return dp[n][s];
        if(s>=weight[n-1]){
            int a = knapSack(s-weight[n-1],item,weight,n-1) + item[n-1];
            int b = knapSack(s,item,weight,n-1);
            return dp[n][s] = max(a,b);
        }
        else{
            int b = knapSack(s,item,weight,n-1);
            return dp[n][s] = b;
        }
    }
    int knapSack(int s, vector<int> &item, vector<int> &weight) {
        // code here
        for(int i =0; i<=item.size(); i++)
        {
            for(int j =0; j<=item.size(); j++)
            {
                if(i ==0 || j==0) dp[i][j] = 0;
            }
        }
        return knapSack(s,item,weight,item.size());
    }


