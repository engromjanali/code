#include<bits/stdc++.h>
using namespace std;

int main(){

    queue<string>name;
    int a;
    cin>>a;
    while(a--)
    {
        int x;
        cin>>x;
        if(x==1)
        {
            if(name.empty()) cout<<"Invalid"<<endl;
            else{
                cout<<name.front()<<endl;
                name.pop();
            }
        }
        else{
            string n;
            cin>>n;
            name.push(n);
        }
    }

return 0;
}