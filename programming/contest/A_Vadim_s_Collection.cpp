#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin>>t;
    while (t--)
    {
        int num[10];
        int fin[10];
        string s;
        cin>>s;
        for(int i =0; i<10; i++){
            num[i] = s[i]-48;
        }
        
        // sort(num, num+10, greater<int>());// decending
        sort(num, num+10); // assending
     
        for(int i =0; i<10; i++){
           for(int j =0; j<10; j++){
               if(9-i<=num[j]){
                  fin[i] = num[j];
                  num[j] =-1;
                  break;
               }
           }
        }

        for(int i =0; i<10; i++){
            cout<<fin[i];
        }
        cout<<endl;
        
    }
    

return 0;
}