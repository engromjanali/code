// #include<bits/stdc++.h>
// using namespace std;

// int main(){

//     int a; cin>>a;
//     vector<int>v1;
//     int x;
//     while(a--)
//     {
//         cin>>x;
//         v1.push_back(x);
//     }

//     cin>>a;
//     vector<int>v2;
//     while(a--)
//     {
//         cin>>x;
//         v2.push_back(x);
//     }
//     vector<int>arr;
//     while(!v1.empty() || !v2.empty())
//     {
//         if(v1.empty())
//         {
//             arr.push_back(v2.back());
//             v2.pop_back();
//         }
//         else if(v2.empty())
//         {
//             arr.push_back(v1.back());
//             v1.pop_back();
//         }
//         else{
//             if(v1.back() < v2.back())
//             {
//                 arr.push_back(v1.back());
//                 v1.pop_back();
//             }
//             else{
//                 arr.push_back(v2.back());
//                 v2.pop_back();
//             }
//         }
//     }
//     reverse(arr.begin(),arr.end());
//     for(auto it = arr.begin(); it != arr.end(); it++)
//     {
//         cout<<*it<<" ";
//     }
// return 0;
// }


#include<bits/stdc++.h>
using namespace std;

int main(){

    vector<vector<int>>v(5); //5 2D vector has created. 1st way
    vector<int>v[5]; //5 2D vector has created. 2nd way
    v[0].push_back(5345);
    v[0].push_back(54);

    v[4].push_back(323);


return 0;
}