#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin>>t;
    while (t--)
    {
        int n; cin>>n;
        vector<int>arr;
        for(int i =0; i<n; i++)
        {
            int a ;
            cin>>a;
            arr.push_back(a);
        }
        
        int odd_size, even_size;
        odd_size = (arr.size()+1)/2;
        even_size = arr.size()/2;

        long long odd_sum=0,even_sum=0;
        for(int i =0; i<n; i++)
        {
            if((i+1)%2==0)
            {
                even_sum +=(long)arr[i];
            }
            else odd_sum +=(long)arr[i];
        }
        if(even_sum/even_size == odd_sum/odd_size && even_sum%even_size==0 &&odd_sum%odd_size==0) 
            cout<<"YES\n";
        else cout<<"NO"<<endl;
        // cout<<even_sum<<" "<<even_size<<" "<<odd_sum<<" "<<odd_size<<endl;
    }
return 0;
}