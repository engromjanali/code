// without using hassing 

#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin>>t;
    while(t--)
    {
        // insertion
        int N;
        cin>>N;
        int * arr = new int[N];
        for(int i =0; i<N; i++)
        {
            cin>>arr[i];
        }

        // opration 
        priority_queue<int, vector<int>, greater<int>>m_pq;
        for(int i =0; i<N; i++)
        {
            m_pq.push(arr[i]);
        }
        
        int res =INT_MIN;
        int freq =0;
        int temp_res = INT_MIN;
        int temp_count = 0;
        while (!m_pq.empty())
        {
            int a = m_pq.top();
            m_pq.pop();

            if(temp_res == a)
            {
                temp_count++;
            }
            else if(temp_count>=freq)
            {
                res = temp_res;
                freq = temp_count;
                 
                temp_res = a;
                temp_count=1;
            }
            else{
                temp_res= a;
                temp_count =1;
            }
            // cout<<a<<" ";
        }
        if(temp_count>=freq)
        {
            freq = temp_count;
            res = temp_res;
        }
        cout<<res<<" "<<freq<<endl;
    }

return 0;
}

