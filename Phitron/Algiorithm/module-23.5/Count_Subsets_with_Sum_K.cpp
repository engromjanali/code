//https://www.codingninjas.com/studio/problems/number-of-subsets_3952532?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
int findWays(vector<int>& arr, int target)
{
	int n = arr.size();
	long long dp[n+1][target+1];
    for(int j =0; j<=target; j++)
    {
        dp[0][j] = 0;
    }
	dp[0][0] = 1;
        
	for(int i =1; i<=n; i++)
    {
        for(int j =0; j<=target; j++)
        {
            if(arr[i-1] <= j){
				long long a = dp[i-1][j-arr[i-1]];
				long long b = dp[i-1][j];
				dp[i][j] = (a+b)%1000000007;
			}
			else{
				dp[i][j] = dp[i-1][j];
			}
        }
    }
	return dp[n][target];
}
