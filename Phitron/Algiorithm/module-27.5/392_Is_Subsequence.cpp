//https://leetcode.com/problems/is-subsequence/description/
class Solution {// O(N)
public:
    bool isSubsequence(string s, string t) {
        int i =0; 
        bool flag= false;
        for( char x : t){
            if(x==s[i]) i++;
            if(i==s.size()){
                flag = true;
                break;
            }
        }
        if(s=="") flag = true;
        return flag;
    }
};