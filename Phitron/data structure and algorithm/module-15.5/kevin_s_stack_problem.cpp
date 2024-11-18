#include<bits/stdc++.h>
using namespace std;
string kevinStackProblem(string &s)
{
	stack<char>a;
	for(char x : s)
	{
		a.push(x);
	}
	s = "";
	while(!a.empty())
	{
		s+=a.top();
		a.pop();
	}
	return s;
}
