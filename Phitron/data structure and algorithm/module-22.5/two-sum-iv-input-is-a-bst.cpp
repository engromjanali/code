// it's can be solved by o(N log(N)).

class Solution {
public:

    vector<int>v;
    
    void convert(TreeNode  * root,  vector<int>&v)
    {
        if(root == NULL) return;
        v.push_back(root->val);
        convert(root->left, v);
        convert(root->right, v);
    }
    
    bool resul(vector<int>v, int k)
    {
                

        for(int i =0; i<v.size(); i++)
        {
            for(int j =0; j<v.size(); j++)
            {
                if(i==j) continue;
                if(v[i]+v[j] == k) return true;
            }
        }
        return false;
    }
    bool findTarget(TreeNode* root, int k) {
        v.clear();
        convert(root, v);
        bool res = resul(v,k);
        return res;
    }
};