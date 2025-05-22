#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int arr[n];
        for(int i =0; i<n; i++)
        {
            cin>>arr[i];
        }
        bool flag = false;
        for(int i =1; i<n; i++){
            int Min = min(arr[i],arr[i-1]);
            int Max = max(arr[i],arr[i-1]);
            if(2*Min>Max){
                flag = true;
                break;
            }
        }
        if(flag) cout<<"YES"<<endl;
        else cout<<"NO"<<endl;


    }

return 0;
}