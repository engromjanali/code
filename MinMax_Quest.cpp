#include<bits/stdc++.h>
using namespace std;
class cmp{
    public:
    bool operator()(pair<int,int>a, pair<int,int>b){
        if(a.first> b.first) return true;
        else return false;
    }
};
int main(){

    int q;
    cin>>q;
    vector<pair<int,int>>v();
    while (q--)
    {
        int a;
        cin>>a;
        if(a==1){
            int x;
            cin>>x;
            v.push({})
        }
        else{
            if(v.empty()){
                cout<<"empty\n";
            }
            else{

            }
        }
    }
    
return 0;
}


// #include<bits/stdc++.h>
// using namespace std;
// class cmp{
//     public:
//     bool operator()(pair<int,int>a, pair<int,int>b){
//         if(a.first> b.first) return true;
//         else return false;
//     }
// };
// int main(){

//     int q;
//     cin>>q;
//     priority_queue<pair<int,int>, vector<pair<int,int>>,cmp>pq;
//     while (q--)
//     {
//         int a;
//         cin>>a;
//         if(a==1){
//             int x;
//             cin>>x;
//             pq.push({})
//         }
//         else{
//             if(v.empty()){
//                 cout<<"empty\n";
//             }
//             else{

//             }
//         }
//     }
    
// return 0;
// }



