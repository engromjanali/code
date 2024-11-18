#include <bits/stdc++.h> 
using namespace std;

queue<int> reverseQueue(queue<int> q)
{
    stack<int>a;
    while(!q.empty())
    {
        a.push(q.front());
        q.pop();
    }
    while (!a.empty()) {
        q.push(a.top());
        a.pop();
    }
    return q;
}
