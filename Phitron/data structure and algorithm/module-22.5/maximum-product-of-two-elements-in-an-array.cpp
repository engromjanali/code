class Solution {
public:
    int resul(vector<int>v)
    {
        int res = INT_MIN;
        for(int i =0; i<v.size(); i++)
        {
            for(int j =0; j<v.size(); j++)
            {
                if(i==j) continue;
                if((v[i]-1) * (v[j]-1) >res) res = (v[i]-1) * (v[j]-1);
            }
        }
        return res;
    }
    int maxProduct(vector<int>& v) {
        return resul(v);
    }
};