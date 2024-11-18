#include<bits/stdc++.h>
using namespace std;
int main(){

    int x;
    int a;
    string arr;
    cin>>x;
    while(x--){
        char sp=' ';
        int count=0;
        cin>>a;
        cin.ignore();
        getline(cin,arr);
        sort(arr.begin(), arr.end());

        while(a--){
            if(arr[a]==sp){
                count++;
            }
            else{
                count+=2;
                sp=arr[a];
            }
        }
        cout<<count<<endl;
    }
return 0;
}