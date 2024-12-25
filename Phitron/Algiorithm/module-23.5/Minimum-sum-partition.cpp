//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {

  public:
    int minDifference(vector<int>& arr) {
        // Your code goes here
        int n = arr.size();
        int sum =0;
        for(int i =0; i<arr.size(); i++)
        {
          sum +=arr[i];
        } 
        int target = sum;
        int dp[n+1][target+1];
        for(int i =0; i<=target; i++)
        {
            dp[0][i] = 0;
        }
        dp[0][0] = 1;

	    for(int i =1; i<=n; i++)
        {
            for(int j =0; j<=target; j++)
            {
                if(arr[i-1] <= j){
	    			int a = dp[i-1][j-arr[i-1]];
	    			int b = dp[i-1][j];
	    			dp[i][j] = (a+b);
	    		}
	    		else{
	    			dp[i][j] = dp[i-1][j];
	    		}
            }
        }
        vector<int>res;
	    for(int i =0; i<=n; i++)
        {
            for(int j =0; j<=target; j++)
            {
                if(dp[i][j]!= 0){
                    res.push_back(j);
                    // int asdfdf = dp[i][j];
                    // return dp[7][0];
                }
            }
        }
        int ans = INT_MAX;
        for(int x : res)
        {
            int a = x;
            int b = sum -x;
            ans = min(ans, abs(a-b));
        }
        return ans;
    }
};


//{ Driver Code Starts.
int main() {
    string ts;
    getline(cin, ts);
    int t = stoi(ts);
    while (t--) {

        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        int ans = ob.minDifference(arr);

        cout << ans << endl;
    }
    return 0;
}
// } Driver Code Ends