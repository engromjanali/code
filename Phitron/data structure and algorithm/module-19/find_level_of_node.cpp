#include <bits/stdc++.h> 
/************************************************************

    Following is the TreeNode class structure

    template <typename T>
    class TreeNode {
       public:
        T val;
        bool isOriginal;
        TreeNode<T> *left;
        TreeNode<T> *right;
        
        TreeNode(T val) {
            this->val = val;
            left = NULL;
            right = NULL;
        }
    };

************************************************************/
// we are geting track level here as pair.second;
int nodeLevel(TreeNode<int>* root, int search)
{
    if(root == NULL ) return 0;
    queue<pair<TreeNode<int>* , int>> q;
    q.push({root,1});

    while(!q.empty())
    {
        pair<TreeNode<int>* , int> pr = q.front();
        q.pop();
        if(pr.first->val == search) return pr.second; // return level
        
        if(pr.first->left != NULL)
            q.push({pr.first->left , pr.second + 1}) ;
            
        if(pr.first->right != NULL)
            q.push({pr.first->right , pr.second + 1}) ;
         
    }
    
}


