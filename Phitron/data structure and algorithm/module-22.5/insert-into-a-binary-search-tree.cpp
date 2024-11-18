/************************************************************

    Following is the TreeNode class structure

    template <typename T>
    class TreeNode
    {
    public:
        T val;
        TreeNode<T> *left, *right;
        TreeNode() : val(0), left(NULL), right(NULL) {}
        TreeNode(T x) : val(x), left(NULL), right(NULL) {}
        TreeNode(T x, TreeNode<T> *left, TreeNode<T> *right) : val(x), left(left), right(right) {}
    };


************************************************************/
void inc(TreeNode<int>*& root, int val)
{
    if(root == NULL)
    {
        root = new TreeNode<int>(val);
        return;
    }
    if(root->val > val) inc(root->left, val);
    if(root->val < val) inc(root->right, val);
}
TreeNode<int>* insertionInBST(TreeNode<int>* root, int val)
{
    inc(root,val);
    return root;
}