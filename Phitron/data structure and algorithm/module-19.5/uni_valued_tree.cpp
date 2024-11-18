/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool fun(TreeNode * root , int x)
    {
        if(root == NULL) return true;
        
        if(root->val != x) return false;

        bool  l = fun(root->left, x);    
        bool  r = fun(root->right, x);

        if(l && r) return true;
        else return false;
    }

    bool isUnivalTree(TreeNode* root) {
        return fun(root,root->val);
    }
};