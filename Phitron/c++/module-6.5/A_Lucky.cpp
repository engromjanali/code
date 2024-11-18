#include<bits/stdc++.h>
using namespace std;
int main(){

    int x ;
    cin>>x;
    getchar();
    string s;
    int a[6];
    for(int i=0; i<x; i++){
        getline(cin, s);
        for(int j=0; j<6; j++){
            a[j]=s[j]-48;
        }

    if((a[0]+a[1]+a[2])==(a[3]+a[4]+a[5])){
        cout<<"YES"<<endl;
    }
    else{
        cout<<"NO"<<endl;
    }
    }

return 0;
}