#include<bits/stdc++.h>
using namespace std;

int main(){

int t;
cin>>t;
while (t--)
{   
    int a,b,res;
    cin>>a>>b;
    for(int i =min(a,b) ; i<INT_MAX; i++)
    {
        if(i%a ==i%b){
            res = i;
            break;
        }
    }
    cout<<res<<endl;
}
return 0;
}