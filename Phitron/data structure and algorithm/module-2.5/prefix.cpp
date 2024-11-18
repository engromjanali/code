// prefix and data stacture. 
// Prefix is a array where we was store the normal array index value and pre value of this prefix.
// prefix fast indix value store data menully. pre[0]=arr[0];
#include<bits/stdc++.h>
using namespace std;

int main(){

    int N, Q;
    cin>>N>>Q;
    int A[N];

    for(int i =0; i<N; i++)
    {
        cin>>A[i];
    }
    long long int pre[N];
    pre[0]= A[0];
    for(int i =1; i<N; i++)
    {
        pre[i] = A[i] + pre[i-1];
    }
    
    while(Q--)
    {
        int L,R;
        cin>>L>>R;
        long long int res;
        L--;
        R--;

        if(L==0) res=pre[R];
        else res = pre[R]-pre[L-1];

        cout<<res<<endl;
    }

return 0;
}

// // normal way without data stacture.
// #include<bits/stdc++.h>
// using namespace std;

// int main(){

//     int N, Q;
//     cin>>N>>Q;
//     int A[N];
//     for(int i =0; i<N; i++)
//     {
//         cin>>A[i];
//     }
//     while(Q--)
//     {
//         int L,R;
//         cin>>L>>R;
//         long long int res = 0;
//         for(int i=L-1; i<R; i++)
//         {
//             res+=A[i];
//         }
//         cout<<res<<endl;
//     }

// return 0;
// }
