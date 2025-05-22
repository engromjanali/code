#include<bits/stdc++.h>
using namespace std;
long long fun(long long n){
    if(n<4) return 1;
    long long a = fun (n/4);
    return (2 * a);
}
int main(){

    int t; cin>>t;
    while (t--)
    {
        long long n; cin>>n;
        if(n<4){
            cout<<"1"<<endl;
            continue;
        }
        cout<<fun(n)<<endl;
    }
    

return 0;
}