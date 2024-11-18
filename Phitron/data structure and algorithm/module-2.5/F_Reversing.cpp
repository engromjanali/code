// #include<bits/stdc++.h>
// using namespace std;
// int main(){

//     int N;
//     cin>>N;
//     vector<int>A;
//     for(int i =0; i<N; i++)
//     {   
//         int x;
//         cin>>x;
//         A.push_back(x);
//     }
//     int i=0;
//     while(i<N-1)
//     {
//         A[i]=A[i]+A[N-1];
//         A[N-1] = A[i]-A[N-1];
//         A[i] = A[i]-A[N-1];
//         i++;
//         N--;
//     }
//     for(int x :A)
//     {
//         cout<<x<<" ";
//     }

// return 0;
// }

// reverse vector 2nd way:
#include<bits/stdc++.h>
using namespace std;
int main(){

    int N;
    cin>>N;
    vector<int>A;
    for(int i =0; i<N; i++)
    {   
        int x;
        cin>>x;
        A.push_back(x);
    }
    int i=0;
    reverse(A.begin(), A.end());
    for(int x :A)
    {
        cout<<x<<" ";
    }

return 0;
}
