#include<bits/stdc++.h>
using namespace std;

int main(){

    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        list<int>lst;
        for(int i  =0; i<n; i++)
        {
            int a; cin>>a;
            lst.push_back(a);
        }
        lst.sort();
        lst.unique();
        for(auto i =lst.begin(); i!=lst.end(); i++)
        {
            cout<<*i<<" ";                    
        }
        cout<<endl;
    }
return 0;
}
