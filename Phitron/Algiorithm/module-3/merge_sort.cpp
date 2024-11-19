#include<bits/stdc++.h>
using namespace std;

    const int N=1e5+7;
    int arr[N];

void merge(int left, int right, int mid)  // conquer
{
    int L[mid - left + 2];//one for (enfinity), one for (it's size where it was index).
    int R[right - mid + 1]; // one for (infinity).

    // insert in current array from main array.
    for(int i = left, j=0; i<=mid; i++,j++)
    {
        L[j]=arr[i];
    }
    for(int i = mid+1, j=0; i<= right; i++, j++)
    {
        R[j] = arr[i];
    }

    //insert infinity value in last index of both array(L,R). for mantain max value.
    L[mid-left+1] = INT_MAX;
    R[right-mid] = INT_MAX;

    // inserting this value in main array as sorted in assending order in same place.
    int lp=0, rp =0;
    for(int i=left; i<=right; i++)
    {
        if(min(L[lp], R[rp]) == L[lp])
        {
            arr[i]= L[lp];
            lp++;
        }
        else{
            arr[i]= R[rp];
            rp++;
        }
    }
}

void mergesort(int f,int l){  //devide

    if(f == l) return;
    int mid = (f+l)/2;
    mergesort(f , mid);
    mergesort((mid+1),l);
    merge(f,l,mid);

    // if(f<l)  it's standerd for hendel exception
    // {
    //     int mid = (f+l)/2;
    //     mergesort(f , mid);
    //     mergesort((mid+1),l);
    //     merge(f,l,mid);
    // }
}


int main(){

    int n;
    cin>>n;
    for(int i =0; i<n; i++)
    {
        cin>>arr[i];
    }
    mergesort(0, n-1);
    for(int i = 0; i<n; i++)
    {
        cout<<arr[i]<<" ";
    }

return 0;
}
