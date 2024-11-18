#include<bits/stdc++.h>
using namespace std;

class MyStack {
    public:
    MyStack() {
        
    }
    queue<int>a;

    void push(int x) {
        a.push(x);
    }
    
    int pop() {
        queue<int>b;
        int x ;
        while(!a.empty())
        {
            x = a.front();
            a.pop();
            if(a.empty()) break;
            b.push(x);
        }
        a=b;
        return x;
    }
    
    int top() {
        queue<int>b;
        int x ;
        while(!a.empty())
        {
            x = a.front();
            a.pop();
            b.push(x);
        }
        a=b;
        return x;
    }
    
    bool empty() {
        return a.empty();
    }
};