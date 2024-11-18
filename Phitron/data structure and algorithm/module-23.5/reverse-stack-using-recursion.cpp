void reverseStack(stack<int> &s) {
    if(s.empty()) return;

    int x = s.top();
    s.pop();

    reverseStack(s);
    stack<int>nst;
    while(!s.empty())
    {
        nst.push(s.top());
        s.pop();
    }
    nst.push(x);
    while(!nst.empty())
    {
        s.push(nst.top());
        nst.pop();
    }
}