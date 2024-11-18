#include <bits/stdc++.h> 
using namespace std;

int findSecondLargest(int n, vector<int> &arr)
{
    set<int>st;
    while(!arr.empty())
    {
        st.insert(arr.back());
        arr.pop_back();
    }
    if(st.size() < 2) return -1;
    
    // //fast way...
    // int idx = 0;
    // for(auto it=st.begin(); it!=st.end(); it++)
    // {
    //     if(idx==st.size()-2)
    //     {
    //         return *it;
    //     }
    //     idx++;
    // }

    //2nd way..
    auto it=st.begin();
    int x=st.size()-2;
    advance(it, x); // increment itrator x time.
    if(it != st.end())
    {
        return *it;
    }
}