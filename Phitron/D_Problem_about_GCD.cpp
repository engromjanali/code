#include<bits/stdc++.h>
using namespace std;
long long find_a(long long l, long long g){
    for(long long i =0; i<=g;i++)
    {
    if((l+i)%g==0)
        return l+i;
    }
}
long long find_b(long long l, long long g){
    for(long long i =0; i<=g;i++)
    {
    if((l-i)%g==0)
        return l-i;
    }
}
int main(){

    int t; cin>>t;
    while(t--){
        long long l, r, g; 
        cin>>l>>r>>g;
        long long a = find_a(l,g);
        long long b = find_b(r,g);
        if(a>b ){
            cout<<"-1 -1"<<endl;
            continue;
        }
        cout<<a<<" "<<b<<endl;
    }

return 0;
}