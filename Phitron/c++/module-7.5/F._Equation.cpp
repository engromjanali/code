#include<bits/stdc++.h>
using namespace std;
int power(int x, int y)
{   
    int res=1;
    while(y--)
    {
        res*= x;
    }
    return res;
}
int main()
{
int A, N;
cin >>A >> N;
int result = 0;
for(int i =0; i<=N; i+=2)
{   
    result += power(A,i); 
}
    cout<< result;
}