// 1 -> always yes. 
// 3 -> n>=3 or d%3==0. 
// 5 -> d==5. 
// 7 -> d==7 or n>=3. 
// 9 -> d==9 or n>=6 or (n>=3 && d%3==0)
#include<bits/stdc++.h>
using namespace std;

int main(){

    int t; cin>>t;
    while(t--)
    {
        int n; cin>>n;
        int d ; cin>>d;
        vector<int>res;
        res.push_back(1);
        if(n>=3 || d%3==0)
            res.push_back(3);
        if(d==5)
            res.push_back(5);
        if(d==7 || n>=3) 
            res.push_back(7);
        if(d==9 || n>=6 || (n >= 3 && d%3==0))
        {
            res.push_back(9);
        }
        for(int x : res)
        {
            cout<<x<<" ";
        }
        cout<<endl;
    }

return 0;
}