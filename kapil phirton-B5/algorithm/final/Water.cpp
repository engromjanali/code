#include<bits/stdc++.h>
using namespace std;
typedef pair<int,int>pir;
int main(){

    int t; cin>>t;
    while (t--)
    {
        int n; cin>>n;
        int arr_H[n];
        for(int i =0; i<n; i++)
        {
            cin>>arr_H[i];
        }
        pir fast_push={INT_MIN,INT_MIN}, second_push={INT_MIN,INT_MIN};

        priority_queue<pir>pq;
        for(int i =0; i<n; i++)
        {
            pq.push({arr_H[i],i});
            if(arr_H[i]>fast_push.first || arr_H[i]>second_push.first)
            {
                fast_push = max(fast_push,second_push);
                second_push={arr_H[i],i};
            }
            
        }
        // cout<<fast_push.second<<" "<<second_push.second<<endl; // fast way O(N).
        pir a = pq.top(); pq.pop();
        pir b = pq.top();
        
        cout<<min(a.second,b.second)<<" "<<max(a.second,b.second)<<endl; // second way O(N log N).
    }
    

return 0;
}