#include<bits/stdc++.h>
using namespace std;
int main(){

    int N;
    cin>>N;
    priority_queue<int, vector<int>, greater<int>>num;
    while(N--)
    {
        int a;
        cin>>a;
        num.push(a);
    }
    int Q;
    cin>>Q;
    while (Q--)
    {
        int command;
        cin>>command;
        if(command == 0)
        {
            int a;
            cin>>a;
            num.push(a);

            int min = num.top();
            cout<<min<<endl;
        }
        else if(command == 1)
        {
            if(num.size()==0) cout<<"Empty"<<endl;
            else{
                int min = num.top();
                cout<<min<<endl;
            }
        }
        else{
            if(num.size()==0) cout<<"Empty"<<endl;
            else if(num.size()==1){
                num.pop();
                cout<<"Empty"<<endl;
            }
            else{
                num.pop();
                int min = num.top();
                cout<<min<<endl;
            }
        }
    }
    
return 0;
}