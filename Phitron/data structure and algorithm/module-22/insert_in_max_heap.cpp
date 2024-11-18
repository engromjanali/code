#include<bits/stdc++.h>
using namespace std;

void insert_max_heap(vector<int>&v)
{
    int n;
    cin>>n ;
    while(n--)
    {
        int a;
        cin>>a;
        v.push_back(a);
        int cur_idx = v.size()-1;
        while (cur_idx != 0)
        {
            int parent_idx = (cur_idx-1)/2;
            if(v[cur_idx]>v[parent_idx])
            {
                swap(v[cur_idx] , v[parent_idx]);
            }
            else break;
            cur_idx  = parent_idx;
        }
    }
}
int main(){

    vector<int> v;
    insert_max_heap(v);
    
    for(int x : v)
    {
        cout<<x<<" ";
    }

return 0;
}