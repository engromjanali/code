#include<bits/stdc++.h>
using namespace std;

int main(){

    int a;
    cin>>a;
    queue<string>qu;
    while (a--)
    {
        string s;
        cin>>s;
        qu.push(s);
    }
    while(!qu.empty())
    {
        string s = qu.front();
        int A=0, B=0;
        for(char x : s)
        {
            if(x=='A') A++;
            else B++;
        }
        if(A==B) cout<<"YES"<<endl;
        else cout<<"NO"<<endl;
        qu.pop();
    }
    
return 0;
}