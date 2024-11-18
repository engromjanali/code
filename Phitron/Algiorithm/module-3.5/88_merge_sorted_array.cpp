class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        stack<int>a,b;
        while(m--)
        {
            a.push(nums1[m]);
        }
        while(n--)
        {
            b.push(nums2[n]);
        }

        nums1.clear();

        while(!a.empty() || !b.empty())
        {
            if(a.empty())
            {
                nums1.push_back(b.top());
                b.pop();
            }
            else if(b.empty())
            {
                nums1.push_back(a.top());
                a.pop();
            }
            else if(a.top() <= b.top())
            {
                nums1.push_back(a.top());
                a.pop();
            }
            else if(a.top() > b.top())
            {
                nums1.push_back(b.top());
                b.pop();
            }
        }
    }
};