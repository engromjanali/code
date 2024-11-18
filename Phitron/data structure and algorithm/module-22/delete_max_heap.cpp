#include<bits/stdc++.h>
using namespace std;

void delete_max_heap(vector<int>&v)
{
    v[0]=v.back();
    v.pop_back();
    int cur_idx = 0;

    while(true)
    {
        int left_idx = (cur_idx*2)+1;
        int right_idx = (cur_idx*2)+2;
        if(left_idx < v.size() && right_idx < v.size())
        {
            if(v[left_idx]>=v[right_idx] && v[left_idx]>v[cur_idx])
            {
                swap(v[left_idx] , v[cur_idx]);
                cur_idx = left_idx;
            }
            else if(v[right_idx] > v[cur_idx])
            {
                swap(v[right_idx] , v[cur_idx]);
                cur_idx = right_idx;
            }
            else break;
        }
        else if(left_idx <= v.size()-1)
        {
            if(v[left_idx]>v[cur_idx])
            {
                swap(v[left_idx] , v[cur_idx]);
                cur_idx = left_idx;
            }
            else break;
        }
        else break;
    }
}

int main(){

    vector<int> v;
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
            if(v[cur_idx] > v[parent_idx])
            {
                swap(v[cur_idx] , v[parent_idx]);
            }
            else break;
            cur_idx  = parent_idx;
        }
    }

    delete_max_heap(v);
    
    for(int x : v)
    {
        cout<<x<<" ";
    }

return 0;
}