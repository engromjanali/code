//  \   / 
//   \ /  
//    X   
//   / \  
//  /   \ 
// book-123p

#include<bits/stdc++.h>
using namespace std;
int main(){

    int M;
    cin>>M;
    // upper site.
    int X=M-2;
    for(int j=0; j<M/2;j++)
    {
        for(int i=0; i<j; i++){
            cout<<" ";
        }
        cout<<"\\";
        for(int i=0; i<X; i++){
            cout<<" " ;
        }
        X-=2;
        cout<<"/"<<endl;
    }
    // midel part
        for(int i=0; i<M/2; i++){
            cout<<" " ;
        }
        cout<<"X"<<endl;
    // lower part
    X=1;
    for(int j=M/2; j>0;j--)
    {
        for(int i=1; i<j; i++){
            cout<<" ";
        }
        cout<<"/";
        for(int i=0; i<X; i++){
            cout<<" ";
        }
        X+=2;
        cout<<"\\"<<endl;
    }

return 0;
}