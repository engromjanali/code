// #include<bits/stdc++.h>
// using namespace std;

// class Solution {
// public:
//     int search(vector<int>&v, int f, int l, int target)
//     {
//         // arr={2,5} target =0;
//         if(f>l) return -1; // we mast have to use ">" the symble to control.
//         int mid = (f+l)/2;
//         if(v[mid] == target) return mid;
//         int left =-1;
//         int right =-1;
//         if(v[mid] > target)
//         {
//             int L = mid-1;
//             left = search(v,f,L,target);
//         }
            
//         if(v[mid] < target)
//         {
//             int F = mid+1;
//             right = search(v,F,l,target);
//         }
            
//         if(left != -1) return left;
//         else return right;
//     }
//     int search(vector<int>& nums, int target) {
//         int res = search(nums,0,nums.size()-1, target);
//         return res;
//         }
// };

// 2nd way
#include<bits/stdc++.h>
using namespace std;

int main(){

    
vector<int> v={5};
int f =0;
int l = v.size()-1;
int target = 5;

int res =-1;
while(f<=l) // we mist have to use "<=". because for a single value "l==r".
{
    int mid = (l + f)/2;
    if(v[mid] == target)
    {
        res = mid;
        break;
    } 
    if(v[mid] >  target)
    {
        l = mid-1;
    }
    else f = mid + 1;
}
cout<<res;
return 0;
}