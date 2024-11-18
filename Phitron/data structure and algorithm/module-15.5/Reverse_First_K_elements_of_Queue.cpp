#include<bits/stdc++.h>
using namespace std;
queue<int> reverseElements(queue<int> q, int k)
{
    stack<int>a;
    queue<int>b;

    while(k--)
    {
        a.push(q.front());
        q.pop();
    }
    while(!q.empty())
    {
        b.push(q.front());
        q.pop();
    }
    while(!a.empty())
    {
        q.push(a.top());
        a.pop();
    }
    while(!b.empty())
    {
        q.push(b.front());
        b.pop();
    }
    return q;
}
