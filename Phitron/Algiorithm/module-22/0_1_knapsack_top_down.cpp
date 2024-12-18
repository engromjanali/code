#include<bits/stdc++.h>
using namespace std;
int dp[10000][10000];
int Knapsack(int n, int s, int item[], int weight []){ //O(n * s)
    // cout<<n<<s<<endl;
    if(n<1 || s<1) return 0;
    if(dp[n][s] != -1) return dp[n][s];
    if(s>=weight[n-1]){
        int a = Knapsack(n-1,s-weight[n-1],item,weight) + item[n-1];
        int b = Knapsack(n-1,s,item,weight);
        return dp[n][s] = max(a,b);
    }
    else{
        int b = Knapsack(n-1,s,item,weight);
        return dp[n][s] = b;
    }
}
int main(){

    int n,w;
    cin>>n>>w;          
    int value[n];
    int weight[n];

    for(int i =0; i<=n; i++)
        for(int j =0; j<=w; j++)
            dp[i][j]=-1;
        
    

    for(int i =0; i<n; i++)
    {
        int v ,wit;
        cin>>v>>wit;
        value[i]= v;
        weight[i] = wit;
    }
    cout<<Knapsack(n,w,value,weight);
return 0;

}