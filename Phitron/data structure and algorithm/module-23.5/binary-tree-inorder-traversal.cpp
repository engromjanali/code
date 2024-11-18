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
    vector<int>v;
    void in_order(TreeNode * root, vector<int> &v)
    {
        if(root == NULL) return;
        in_order(root->left,v);
        v.push_back(root->val);
        in_order(root->right,v);
    }
    vector<int> inorderTraversal(TreeNode* root) {
        in_order(root,v);
        return v;
    }
};