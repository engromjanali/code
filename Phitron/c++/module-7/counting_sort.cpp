// it;s solved by counting sort.

#include<bits/stdc++.h>
using namespace std;
int main(){

    int N;
    cin>> N;

    int count[26] = {0};
for(int i=0; i<N; i++)
{
    char a;
    cin>>a;
    count[a-'a']++;
}
for(char i='a'; i<='z'; i++)
{
    if(count[i-'a']>0)
    {
        for(int j=0; j<count[i-'a']; j++)
        {
            cout<<i;
        }
    }
}

return 0;
}