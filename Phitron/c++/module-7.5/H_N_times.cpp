#include<bits/stdc++.h>
using namespace std;

void fun(int a, char c)
    {  
        if(a == 0 ) return;
        fun(a-1, c); 
        cout<<c<< " ";    
    }

int main(){
    int T;
    cin>> T;
    while(T--)
    {
        int A;
        char C;

        cin>> A;
        cin.ignore();
        cin>> C;

        fun(A, C);
        cout<<endl;

    }

return 0;
}