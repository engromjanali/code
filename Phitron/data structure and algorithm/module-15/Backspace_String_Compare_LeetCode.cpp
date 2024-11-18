#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool backspaceCompare(string s, string t) {
        stack<char>a,b;
        for(char x : s)
        {
            if(x != '#') a.push(x);
            else if(!a.empty()) a.pop();
        }
        for(char x : t)
        {
            if(x != '#') b.push(x);
            else if(!b.empty()) b.pop();
        }
        if(a.size() != b.size()) return false;
        while(!a.empty())
        {
            if(a.top() != b.top()) return false;
            a.pop();
            b.pop();
        }
        return true;
    }
};
