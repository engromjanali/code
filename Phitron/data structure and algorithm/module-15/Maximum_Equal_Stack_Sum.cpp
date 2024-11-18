#include <bits/stdc++.h> 
using namespace std;
int Sum(stack<int>a)
{
    int sum = 0;
    while(!a.empty())
    {
        sum += a.top();
        a.pop();
    }
    return sum;
}
int maxSum(stack<int> &stk1, stack<int> &stk2, stack<int> &stk3) {

    int a,b,c;
    a = Sum(stk1);
    b = Sum(stk2);
    c = Sum(stk3);

    while(true)
    {
        if(a==b && b==c)
        {
            return a;
        }
        else if(a>=b && a>=c)
        {
            a-=stk1.top();
            stk1.pop();
        }
        else if(b>=a && b>=c)
        {
            b-=stk2.top();
            stk2.pop();
        }
        else if(c>=b && c>=a)
        {
            c-=stk3.top();
            stk3.pop();
        }
    }
}
