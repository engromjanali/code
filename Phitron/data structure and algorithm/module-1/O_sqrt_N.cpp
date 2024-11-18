// O(sqrt(N))
// we know 1s = 10**7. if we execute a opration until 10**14 we get a error(TLE). but we can a execute it as (sqrt(10**14)==10**7)
#include<bits/stdc++.h>
using namespace std;
int main(){

    int N;
    cin>>N;
    for(int i =1; i<=sqrt(N); i++)
    {
        if(N%i==0)
        {
            if(N/i != i) 
            {
                cout<<i<<endl;
                cout<<N/i<<endl;
            }
            else
            {
                cout<<i;
            }
        }
    }
    // 2nd way
    for(int i =1; i*i<=N; i++)
    {
        if(N%i==0)
        {
            if(N/i != i) 
            {
                cout<<i<<endl;
                cout<<N/i<<endl;
            }
            else
            {
                cout<<i;
            }
        }
    }

return 0;
}