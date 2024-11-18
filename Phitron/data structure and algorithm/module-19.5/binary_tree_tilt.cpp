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
    int fun(TreeNode *& root)
    {
        if(root == NULL) return 0;

        int l = fun(root->left);
        int r = fun(root->right);

        int temp = root->val;
        root->val = abs(l-r);

        return l+r+temp;
    }
    int sum(TreeNode * root)
    {
        if(!root) return 0;
        int l = sum(root->left);
        int r = sum(root->right);

        return l+r+root->val;
    }
    int findTilt(TreeNode* root) {

        fun(root);
        return sum(root);
    }
};