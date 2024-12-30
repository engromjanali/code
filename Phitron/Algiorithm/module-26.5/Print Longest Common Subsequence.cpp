//https://www.naukri.com/code360/problems/print-longest-common-subsequence_8416383?leftPanelTabValue=PROBLEM
string findLCS(int n, int m,string &a, string &b){
	
	int dp[n+1][m+1];
	
	for(int i =0; i<=m; i++)
	{
		dp[0][i] = 0;
	}
	for(int i =0; i<=n; i++)
	{
		dp[i][0] = 0;
	}

	for(int i =1; i<=n; i++)
	{
		for(int j =1; j<=m; j++)
		{
			if(a[i-1] == b[j-1]){
				dp[i][j] = dp[i-1][j-1] + 1;
			}
			else{
				dp[i][j] = max(dp[i-1][j] , dp[i][j-1]);
			}
		}
	}
	string s = "";
	int i =n, j =m;
	while(i!=0 && j!=0 ){
		if(a[i-1] == b[j-1]){
			s+=a[i-1];
			i--;
			j--;
		}
		else{
			if(dp[i-1][j]==dp[i][j]) i--;
			else j--;
		}
	}
	reverse(s.begin(),s.end());
	return s;
}