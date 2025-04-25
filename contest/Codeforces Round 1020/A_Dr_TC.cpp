#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin>>t;
    while (t--)
    {
        int n;
        cin >>n;
        vector<int>arr(n);
        int current_one_per_row=0;
        int total_one=0;
        string s;
        cin>>s;
        for(int i = 0; i<n; i++){
            int a = (int)(s[i]-48);
            arr[i] = a;
            if(a==1) current_one_per_row ++;
        }        

        vector<vector<int>>t_d(n);
        for(int i =0; i<n; i++){
            t_d[i] = arr;
            if(t_d[i][i] ==0){
                t_d[i][i] ==1;
                total_one += (current_one_per_row+1);
            }
            else{
                t_d[i][i] ==0;
                total_one += (current_one_per_row-1);
            }  
        }
        cout<<total_one<<endl;
    }
return 0;
}