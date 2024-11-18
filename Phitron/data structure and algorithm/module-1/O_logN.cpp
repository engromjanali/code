#include<bits/stdc++.h>
using namespace std;
int main(){

    int N;
    cin>> N;
    while(N>0) //O(logN)
    {
        int digit = N%10;
        cout<<digit<<endl;
        N/=10;
    }
    cin>>N;
    for(int i=0; i<N; i*=2)//O(logN)
    {
        cout<<i<<endl;
    }

return 0;
}