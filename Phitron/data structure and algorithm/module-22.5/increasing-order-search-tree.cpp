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
    TreeNode * root2 = NULL;

    void pusH(TreeNode *& root, int val)
    {
        if(root == NULL ) {
            root = new TreeNode(val);
            return;
        }
        pusH(root->right, val);
    }

    void right(TreeNode * root)
    {
        if(root == NULL) return;
        right(root->left);
        pusH(root2,root->val);
        right(root->right);
    }
    TreeNode* increasingBST(TreeNode* root) {
        root2 = NULL;
        right(root);
        return root2;
        
    }
};
