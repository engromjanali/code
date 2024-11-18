
#include<bits/stdc++.h>
using namespace std;
int main(){
    int T;
    cin>>T;
    while(T--){
        int A;
        cin>>A;
        if(A%2 != 0 ){
            int arr[A];
            for(int i =0 ; i < A; i++){
                cin>> arr[i];
            }
            cout << "-1"<<endl;
        }
        
        else{
            int arr[A];
            for(int i =0 ; i < A; i++){
                cin>> arr[i];
            }
            int even =0, odd=0;
            for(int i=0; i<A; i++){
                if(arr[i] %2 == 0){
                    even++;
                }
                else{
                    odd++;
                }
            }
            int res = even-odd;
            res = abs(res)/2;
            cout<< res<<endl;
            
            }
    }

return 0;
}