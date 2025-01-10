#include<bits/stdc++.h>
using namespace std;

bool cmp(pair<string,int>p1 , pair<string,int>p2){
    if(p1.first<p2.first)
        return true;
    else{
        if(p1.first==p2.first)
        {
            if(p1.second>p2.second)
                return true;
            else 
                return false;
        }
        else 
            return false;
    }
}

int main(){

    int n;
    cin>>n;
    list<pair<string,int>>lst;
    while(n--)
    {
        string s; cin>>s;
        int k; cin>>k;
        pair<string,int>p = {s,k};
        lst.push_back(p);
    }
    lst.sort(cmp);
    for(auto it = lst.begin(); it!=lst.end(); it++)
    {
        cout<<it->first<<" "<<it->second<<endl;
    }
return 0;
}