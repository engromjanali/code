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
int mx = 0;
int max_diamieter(TreeNode <int> * root)
{
    if(root ==NULL) return 0;

    int l = max_diamieter(root->left);
    int r = max_diamieter(root->right);

    int d = l+r;
    mx = max(mx , d);// max diameter of any node.
    return max(l,r)+1;
}

int diameterOfBinaryTree(TreeNode<int> *root){
	mx = 0;
    int l = max_diamieter(root->left); // it will return diameter of left site
    int r = max_diamieter(root->right); // // it will return diameter of right site
    return max(mx, l+r); // it's return max diameter;
}
