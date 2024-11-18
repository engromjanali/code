// https://www.codingninjas.com/studio/problems/min-stack_3843991

#include <bits/stdc++.h> 
using namespace std;
class minStack
{
	public:
		stack<int>stk;
		stack<int>min;
		
		// Constructor
		minStack() 
		{ 
			// Write your code here.
		}
		
		// Function to add another element equal to num at the top of stack.
		void push(int num)
		{
			stk.push(num);
			if(min.empty()) min.push(num);
			else if(min.top()>=num) min.push(num);
		}
		
		// Function to remove the top element of the stack.
		int pop()
		{
			if(stk.empty()) return -1;
			int a = stk.top();
			stk.pop();
			if(min.top()==a) min.pop();
			return a;
		}
		
		// Function to return the top element of stack if it is present. Otherwise return -1.
		int top()
		{
			if(stk.empty()) return -1;
			return stk.top();
		}
		
		// Function to return minimum element of stack if it is present. Otherwise return -1.
		int getMin()
		{
			
			if(stk.empty()) return -1;
			return min.top();
		}
};