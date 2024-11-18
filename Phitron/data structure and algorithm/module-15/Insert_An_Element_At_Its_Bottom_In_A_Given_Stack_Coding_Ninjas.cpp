#include <bits/stdc++.h> 
using namespace std;

stack<int> pushAtBottom(stack<int>& myStack, int x) 
{
    stack<int>a;
    while(!myStack.empty())
    {
        a.push(myStack.top());
        myStack.pop();
    }
    a.push(x);
    while(!a.empty())
    {
        myStack.push(a.top());
        a.pop();
    }
    return myStack;
}
