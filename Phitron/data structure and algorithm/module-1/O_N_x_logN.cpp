#include<bits/stdc++.h>
using namespace std; 
int main(){      // final O(N * log(N))

    int N;
    cin>>N;
    for(int i =0; i<N; i++)  //O(N)
    {
        for(int j=0; j<N; j*=2)  // O(log(N))
        {
            cout<<"hello romjan!";
        }
    }
return 0;
}