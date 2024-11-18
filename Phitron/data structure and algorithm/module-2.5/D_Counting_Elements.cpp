#include<bits/stdc++.h>
using namespace std;
int main(){

    int n;
    cin>>n;
    vector<int>a;
    for(int i=0; i<n; i++)
    {
        int x;
        cin>>x;
        a.push_back(x);
    }
    int count =0;
    for(int i =0; i<n; i++){
        auto it = find(a.begin(), a.end(), a[i]+1);
        if(it != a.end()){
            count++;
        }
    }
    cout<<count;
return 0;
}

