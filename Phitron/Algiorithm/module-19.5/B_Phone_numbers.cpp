//https://codeforces.com/contest/25/problem/B
#include<bits/stdc++.h>
using namespace std;

int main(){

    int n;
    cin>>n;
    string s;
    cin>>s;
    if(s.size()%3==0)
    {
        int i =0;
        while(true)
        {
            cout<<s.substr(i,3);
            i+=3;
            if(i>s.size()-3) 
                break;
            else 
                cout<<"-";
        }
    }

    else if(s.size()%2==0)
    {
        int i =0;
        while(true)
        {
            cout<<s.substr(i,2);
            i+=2;
            if(i>s.size()-2) 
                break;
            else 
                cout<<"-";
        }
    }

    else if(s.size()%2==1)
    {
        int i =0;
        cout<<s.substr(i,3);
        i=3;
        while(true)
        {
            if(i<s.size()-1)
            {
                cout<<"-"<<s.substr(i,2);
                i+=2;
            }
            else break;
        }
    }



return 0;
}