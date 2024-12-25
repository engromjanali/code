// https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/V
#include<bits/stdc++.h>
using namespace std;
bool flag = false;
long long target = 0;
bool fun(vector<long long>&arr,int n, long long current){
    if(n<0)
    {
        if(current == target) return true;
        return false;
    } 
    bool a = fun(arr,n-1, current+arr[n]);
    bool b = fun(arr,n-1, current-arr[n]);
    return a||b;
}

int main(){

    int n;
    cin>>n>>target;
    vector<long long>arr(n);
    for(int i =0; i<n; i++)
    {
        cin>>arr[i];
    }
    // fun(arr,n-1, 0);
    if(fun(arr,n-1, 0)) cout<<"YES"<<endl;
    else cout<<"NO"<<endl;


return 0;
}

// solved
#include <bits/stdc++.h>
using namespace std;
long long sz,result;
long long arr[21];
//                 1          1
bool check(long long sum,long index){
	if(index == sz){
		 return sum == result;
	}
	bool route1 = check(sum+arr[index],index+1);
	bool route2 = check(sum-arr[index],index+1);
	return route1 || route2;
}
/*
5 5
1 2 3 4 5
*/
int main() {
	cin>>sz>>result;
	for(int i=0;i<sz;i++){
		cin>>arr[i];
	}
	if(check(arr[0],1)){
		cout<<"YES"<<endl;
	} else {
		cout<<"NO"<<endl;
	}
	
}