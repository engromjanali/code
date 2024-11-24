#include<bits/stdc++.h>
using namespace std;

typedef pair<int,int>pir;
class cmp{
    public:
    bool operator()(pir a, pir b){
        if(a.first < b.first) return false;
        if(a.first == b.first && a.second < b.second ) return false;
    return true;
    }
};
int main(){

    priority_queue<pir, vector<pir>, cmp>q;
    int n;
    cin>>n;
    while(n--)
    {
        int a,b;
        cin>>a>>b;
        q.push({a,b});
    }
    while(!q.empty())
    {
        cout<<q.top().first<<" "<<q.top().second<<endl;
        q.pop();
    }

return 0;
}