#include<bits/stdc++.h>
using namespace std;

bool binary(int * A, int N, int X)
{
        bool res = false;
        int fast =0, last =N-1; 
        while(fast<=last)
        {   
            // int mid=fast + (last-fast)/2;
            int mid=(fast+last)/2; // it's valid also. and more simple.
            
            if(A[mid] == X)
            {
                res=true;
                break;;
            }
            else if(A[mid]<X)
            {
                 fast=mid+1;
            }
            else 
            {
                last = mid-1;
            }
        }
    return res;
}

int main(){

    int N, Q;
    cin>>N>>Q;
    int A[N];
    for(int i =0; i<N; i++)
    {
        cin>>A[i];
    }
    sort(A,A+N);
    while(Q--)
    {
        int X ;
        cin>>X;
        if(binary(A,N,X))
        {
             cout<<"found"<<endl;
        }
        else
        {
            cout<<"not found"<<endl;
        }

    }

return 0;
}
