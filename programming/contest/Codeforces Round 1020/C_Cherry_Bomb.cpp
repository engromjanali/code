#include<bits/stdc++.h>
using namespace std;

int main(){

    int t; 
    cin>>t;
    while (t--)
    {
        bool cango = false;
        int n, k;
        cin>>n>>k;
        int target_index = 0;
        int number_of_minuse_one = 0;
        int arr1[n];
        int arr2[n];
        for(int i =0; i<n; i++){
            cin>>arr1[i];
        }
        for(int i =0; i<n; i++){
            cin>>arr2[i];
            if(arr2[i]!= -1){
                target_index = i;
                cango = true;
            }
            else{
                number_of_minuse_one ++;
            }
        }

        if(number_of_minuse_one<k){
            if(cango){
                int target_number = arr1[target_index] + arr2[target_index];
                bool still_possible = true;
                for(int i =0; i<n; i++){
                    if(arr1[i]!=arr2[i]){
                        cout<<"0"<<endl;
                        still_possible = false;
                        break;
                    }
                }

            }
            else{

            }
        }
        else cout<<"0"<<endl;
    }
    

return 0;
}