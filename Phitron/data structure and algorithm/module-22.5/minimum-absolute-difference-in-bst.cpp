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
    void inorder(TreeNode * root, int&prev, int &min_def)
    { 
        if(root == NULL) return;
        inorder(root->left , prev, min_def); 

        if (prev != -1) 
        {
            min_def = min(min_def, (root->val - prev));
        }
        prev = root->val;

        inorder(root->right , prev , min_def);
    }

    int getMinimumDifference(TreeNode* root) {
        int prev = -1;
        int min_def = INT_MAX;
        inorder(root,  prev, min_def);
        return min_def;
    }
};