// https://atcoder.jp/contests/dp/tasks/dp_a

// The runtime error you're encountering when omitting the reference (&) in the top_down function is likely related to inefficient memory usage or stack overflow due to excessive copying of the height vector.

// Here's why:

// 1. Argument Passing Without Reference (&)
// When you pass the height vector by value, a copy of the entire vector is created for each recursive call to top_down. If n is large, this results in:

//     Significant memory overhead because every recursive call involves duplicating the vector.
//     Stack overflow due to excessive recursion depth and large copies being placed on the call stack.
// 2. Argument Passing With Reference (&)
// When you pass the height vector by reference (e.g., vector<int>& height), no copying occurs. Instead, the function operates on the original vector, avoiding unnecessary memory usage and reducing the load on the call stack.

// 3. Why Is It an Issue Despite Not Modifying height?
// Even if you are not modifying the height vector, passing it by value leads to:

//     Extra time spent copying the vector.
//     Increased memory usage with every recursive call.
//     A higher likelihood of stack overflow for large input sizes due to deeper recursion and larger stack frames.

#include<bits/stdc++.h>
using namespace std;
vector<int>cost;
int top_down(vector<int>&height, int n)
{
    if(cost[n] != -1) return cost[n];
    else if(n==1) {
        return cost[n] = 0;
    }
    else if(n==2){
        return cost[n] = abs(height[1]- height[2]);
    } 
    else{
    int res1 = top_down(height, n-1) + abs(height[n] - height[n-1]);
    int res2 = top_down(height, n-2) + abs(height[n] - height[n-2]);
    return cost[n]=min(res1,res2);
    }
}

int main(){

    int n;
    cin>>n;
    cost.resize(n+1,-1);
    vector<int>height(n+1);
    for(int i =1; i<=n ; i++)
    {
        cin>>height[i];
    }
    int res = top_down(height,n);
    cout<<res;
return 0;
}