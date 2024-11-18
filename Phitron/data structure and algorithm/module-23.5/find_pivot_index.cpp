class Solution {
public:
    int pivotIndex(vector<int>& v) {
        for(int i =1; i<v.size(); i++ )
        {
            v[i] = v[i-1] + v[i];
        }
        for(int i =0; i<v.size(); i++)
        {
            int left;
            if(i == 0){
                left = 0;
            }
            else left = v[i-1];
            
            int right = v[v.size()-1] - v[i];
            if(left == right) return i;
        }
        return -1;
    }
};