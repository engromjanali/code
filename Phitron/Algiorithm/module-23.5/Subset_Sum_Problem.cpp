//https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//{ Driver Code Starts

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:
    int dp[201][40001];
    bool top_down(vector<int>&arr, int s, int n){
        if(n==0){
            if(s==0)
            return true;
            else return false;
        }
        if(dp[n][s] != -1) return dp[n][s];
        if(arr[n-1]<=s){
            bool a = top_down(arr,s-arr[n-1],n-1);
            bool b = top_down(arr,s,n-1);
            return dp[n][s] = a||b;
        }
        else{
            return dp[n][s] = top_down(arr,s,n-1);
        }
    }
    bool isSubsetSum(vector<int>& arr, int target) {
        for(int i =0; i<=arr.size(); i++)
        {
            for(int j =0; j<=target; j++)
            {
                dp[i][j] = -1;
            }
        }
        return top_down(arr,target,arr.size());
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
        if (ob.isSubsetSum(arr, sum))
            cout << "true" << endl;
        else
            cout << "false" << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends