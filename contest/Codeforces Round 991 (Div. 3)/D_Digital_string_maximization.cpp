#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        string s;
        cin >> s;
        vector<int> digits(s.size());
        for (int i = 0; i < s.size(); i++) // n
            digits[i] = s[i] - '0';
        
        for (int i = 1; i < s.size(); i++) // n
        {
            while(i>0 && digits[i]>digits[i-1]+1)
            {
                swap(digits[i],digits[i-1]);
                digits[i-1]--;
                i--;
            }
        } // n * 10
        for(int x: digits)
        {
            cout<<x;
        }
        cout<<endl;
    }
    return 0;
}

// tc - O(n * 10)
// sc - O(n)