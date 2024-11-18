class Solution {
public:
    bool isValid(string s) {
        stack<char>a;
        for(char x : s)
        {
            if(x =='(' || x =='[' || x =='{')
            {
                a.push(x);
            }
            else if(a.empty()) return false;
            else
            {
                if(x==')' && a.top()=='(') a.pop();
                else if(x=='}' && a.top()=='{') a.pop();
                else if(x==']' && a.top()=='[') a.pop();
                else return false;
            }
        }
    return a.empty();
    }
};