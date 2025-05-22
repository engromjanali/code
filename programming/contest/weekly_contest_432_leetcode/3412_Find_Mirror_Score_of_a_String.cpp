// s consists only of lowercase English letters.
// https://leetcode.com/problems/find-mirror-score-of-a-string/

// O(N*N) -------------------------------------------
// class Solution {
// public:
// long long calculateScore(string s) {
//     int n = s.size();
//     long long ans =0;
//     for(int i =1; i<n; i++)
//     {
//         for(int j = i-1; j>=0; j--)
//         {
//             if((25 -(s[i]-97) ) == s[j]-97){
//                 ans += (long long)(i-j);
//                 s[i] = '-1';
//                 s[j] = '-1';
//             }
//         }
//     }
//     return ans;
// }

 
// O(N);  ------------------------------------------------
// #include<bits/stdc++.h>
// using namespace std;
// class Solution {
// public:
//     char mirror(char ch) {
//         return 'a' + 'z' - ch ;
//     }
//     long long calculateScore(string s) {
//         vector<vector<int>>v(26);
//         long long ans = 0 ;
//         for(int i=0 ; i < s.size() ; i++) {
//             char mir = mirror(s[i]);
//             if(!v[mir-97].empty()) {
//                 ans += (long long) (i-v[mir-97].back());
//                 v[mir-97].pop_back();
//             } else {
//                 v[s[i]-97].push_back(i);
//             }
//         }
//         return ans;
//     }
// };

 
// O(log N);  ------------------------------------------------
class Solution {
public:
    char mirror(char ch) {
        return 'a' + 'z' - ch ;
    }
    long long calculateScore(string s) {
        long long ans = 0;
        map<char , set<int>> map; // we can use here vactor as value.
        map[s[0]].insert(0) ;
        for(int i=1; i<s.size(); i++) {
            char mir = mirror(s[i]) ;
            cout << mir << " " ;
            // if( map.find(mir) != map.end() && map[mir].size() > 0 ) {
            if( map[mir].size() > 0 ) { // we can use it also. because has/map by default value 0 and we didn't should to decler at fast we can access directly. 
                //if( map[mir].size() > 0 ) {
                    auto it = map[mir].rbegin();
                    ans += (long long) (i - *it);
                    map[mir].erase(*it) ; // .erase(it) we can erase by itrator also.
                //}
            } else {
                map[s[i]].insert(i) ;
            }
        }
        return ans ;
    }
};