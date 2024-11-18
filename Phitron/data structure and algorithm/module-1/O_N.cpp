#include<bits/stdc++.h>
using namespace std;
int main(){

    int N;
    cin>> N;
    while(N>0) //O(N)
    {

        cout<<N<<endl;
        N--;
    }
    cin>>N;
    for(int i=0; i<N; i+=10)//O(N)
    {
        cout<<i<<endl;
    }


return 0;
}