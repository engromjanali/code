#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin>>t;
    while (t--)
    {
        string s;
        cin>>s;
        int N;
        cin>>N;
        while (N--)
        {
            int a;
            char b;
            cin>>a>>b;
            s[a-1] =b;
            bool flag = false;
            int siz = s.size();
            for(int i =0 ; i<(siz-3); i++ )
            {
                if(s.substr(i,4) == "1100"){
                    flag = true;
                }
            }
            if(flag) cout<<"YES"<<endl;
            else cout<<"NO"<<endl;
        }
    }
return 0;
}