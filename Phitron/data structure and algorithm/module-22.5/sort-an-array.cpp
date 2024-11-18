#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        vector<int>v;
        while(!nums.empty())
        {
            insert_in_min_heap(v,nums.back());
            nums.pop_back();
        }
        return convert(v);     
    }
    void insert_in_min_heap(vector<int>&v, int a)
    {

        v.push_back(a);
        int cur_idx = v.size()-1;
        while (cur_idx != 0)
        {
            int parent_idx = (cur_idx-1)/2;
            if(v[cur_idx]<v[parent_idx])
            {
                swap(v[cur_idx] , v[parent_idx]);
            }
            else break;
            cur_idx  = parent_idx;
        }
    }

void delete_min_heap(vector<int>&v)
{
    v[0]=v.back();
    v.pop_back();
    int cur_idx = 0;
    int x = v.size()-1;

    while(true)
    {
        int left_idx = (cur_idx*2)+1;
        int right_idx = (cur_idx*2)+2;
        if((left_idx < (v.size())) && (right_idx < (v.size())))
        {
            if(v[left_idx]<=v[right_idx] && v[left_idx]<v[cur_idx])
            {
                swap(v[left_idx] , v[cur_idx]);
                cur_idx = left_idx;
            }
            else if(v[right_idx] < v[cur_idx])
            {
                swap(v[right_idx] , v[cur_idx]);
                cur_idx = right_idx;
            }
            else break;
        }
        
        else if(left_idx <v.size())
        {
            if(v[left_idx]<v[cur_idx])
            {
                swap(v[left_idx] , v[cur_idx]);
                cur_idx = left_idx;
            }
            else break;
        }
        else break;
    }
}

    vector<int> convert(vector<int>v)
    {
        vector<int>temp;
        while(!v.empty())
        {
            temp.push_back(v.front());
            delete_min_heap(v);
            // v.pop_back();
        }
        return temp;
    }
};