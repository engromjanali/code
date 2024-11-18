#include<bits/stdc++.h>
using namespace std;

class MyQueue {
public:
    MyQueue() {
        
    }
    stack<int>a;
    void push(int x) {
        a.push(x);
    }
    
    int pop() {
        stack<int>b;
        int x;
        while(!a.empty())
        {
            x = a.top();
            a.pop();
            if(a.empty()) break;
            b.push(x);
        }
        while(!b.empty())
        {
            a.push(b.top());
            b.pop();
        }
        return x;
    }
    
    int peek() {
        stack<int>b;
        int x;
        while(!a.empty())
        {
            x = a.top();
            a.pop();
            b.push(x);
        }
        while(!b.empty())
        {
            a.push(b.top());
            b.pop();
        }
        return x;
    }
    
    bool empty() {
        return a.empty();
    }
};

