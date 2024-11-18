#include <bits/stdc++.h> 
/************************************************************

    Following is the TreeNode class structure

    template <typename T>
    class TreeNode {
       public:
        T data;
        TreeNode<T> *left;
        TreeNode<T> *right;

        TreeNode(T data) {
            this->data = data;
            left = NULL;
            right = NULL;
        }
    };

************************************************************/

vector<int> getLeftView(TreeNode<int> *root)
{
    int freq[3005] = {0};
    vector<int> v;

    if(root == NULL) return v;

    queue<pair < TreeNode<int> * , int>>q;
    q.push({root,0});
    while(!q.empty())
    {
        // taken
        pair<TreeNode<int> * , int>pr;
        pr = q.front();
        q.pop();

        //opration
        if(freq[pr.second]==0)
        {
            v.push_back(pr.first->data);
            freq[pr.second]=1;
        }

        // insert
        if(pr.first->left)
            q.push({pr.first->left , pr.second+1});
        if(pr.first->right)
            q.push({pr.first->right , pr.second+1});

    }
    return v;
}