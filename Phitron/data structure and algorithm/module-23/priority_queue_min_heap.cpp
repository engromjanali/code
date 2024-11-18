#include<bits/stdc++.h>
using namespace std;

int main(){

    int N;
    cin>>N;

    // it's syntex of min heap.
    priority_queue<int, vector<int>, greater<int>>max_heap;
    
    while(N--)
    {
        int a;
        cin>>a;
        max_heap.push(a);
    }
    
    while(!max_heap.empty())
    {
        cout<<max_heap.top()<<" ";
        max_heap.pop();
    }

return 0;
}