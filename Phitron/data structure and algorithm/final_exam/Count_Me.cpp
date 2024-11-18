#include <bits/stdc++.h>
using namespace std;
int main()
{
   int t;
   cin >> t;
   cin.ignore();
   while (t--)
   {
      string sentecne;
      
      getline(cin, sentecne);
      int mx = 0;
      string ans;
      string word;
      stringstream ss(sentecne);
      map<string, int> mp;
      while (ss >> word)
      {
         mp[word]++;
         if (mx < mp[word])
         {
            mx = mp[word];
            ans = word;
         }
      }
      cout << ans << " " << mx << endl;
   }

   return 0;
}