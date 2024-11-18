class Solution {
public:
    vector<int> leftRightDifference(vector<int>& V) {
        int x =0;
        vector<int>v(V);
        vector<int>v2(V);
        for(int i =0; i<v.size(); i++)
        {
            
            if(i==0)
            {
                x = v[i];
                v[i] = 0;
            } 
            else{
                int x1 = v[i];
                v[i] = v[i-1]+x;
                x=x1;
            }
        }
        
        x =0;
        for(int i =v2.size()-1; i>=0; i--)
        {
            
            if(i==v2.size()-1)
            {
                x = v2[i];
                v2[i] = 0;
            } 
            else{
                int x1 = v2[i];
                v2[i] = v2[i+1]+x;
                x=x1;
            }
        }

        for(int i =0 ; i<v.size(); i++)
        {
            V[i] = abs(v[i]-v2[i]);
        }
        return V;
    }
};