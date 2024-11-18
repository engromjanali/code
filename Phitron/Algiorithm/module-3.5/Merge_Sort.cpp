#include<bits/stdc++.h>
using namespace std;

void merge(vector<int>&v, int f, int l)
{
    int mid = (f+l)/2;
    int left [mid-f+2];
    int right[l-mid+1];
    // load data main vector to two sub-vector
    for(int i =f, j=0; i<=mid; i++,j++)
    {
        left[j] = v[i];
    }
    for(int i = mid+1, j=0; i<=l; i++,j++)
    {
        right[j] = v[i];
    }
    left[(sizeof(left)/4)-1] = INT_MAX;
    right[(sizeof(right)/4)-1] = INT_MAX;
    // inserting agin.

    int p=0, q=0;
    for(int i =f; i<=l; i++)
    {
        if(left[p] > right[q])
        {
            v[i] = (right[q]);
            q++;
        }
        else
        {
            v[i] = (left[p]);
            p++;
        }
    }
}
                
void divide(vector<int>& arr, int f, int l)
{
    if(f==l) return;
    int mid = (l+f)/2;
    divide(arr,f,mid);
    divide(arr,mid+1,l);
    merge(arr,f,l);
}

void mergeSort(vector < int > & arr, int n) {
    divide(arr,0,arr.size()-1);
}