// for |x-y| / k != 0 . we have to choice the x number what isn't same group of y. like 9-3 possible to divid by 3, 9-6/3, so we should choice 9-2 !/ 3. 
#include<bits/stdc++.h>
using namespace std;

int main(){

    int t; cin>>t;
    while(t--)
    {
        int n,k;
        cin>>n>>k;
        vector<vector<int>>v(k);
        int list_of_element[n];
        for(int i =1; i<=n; i++)
        {
            int x; cin>>x;
            v[x%k].push_back(x);// every divisible value for divid k always less then k. i mean (x/k < k).
            list_of_element[i-1]=x;
        }
        int flag = -1;
        for(int i =0; i<k; i++)
        {
            if(v[i].size()==1)
            flag=v[i].front();
        }
        if(flag==-1)
        cout<<"NO\n";
        else 
        {
            for(int i =0; i<n; i++)
            {
                if(list_of_element[i]==flag)
                {
                    flag = i+1; // in problem index atart from 1. 
                    break;
                }
            }
            cout<<"YES"<<endl<<flag<<endl;// for yes return index number.
        }
    }

return 0;
}