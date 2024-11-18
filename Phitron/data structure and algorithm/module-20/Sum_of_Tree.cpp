#include<bits/stdc++.h>
using namespace std;
class NodeTree{
    public :
        int val;
        NodeTree * left;
        NodeTree * right;
        NodeTree(int val)
        {
            this->val=val;
            left=NULL;
            right=NULL;
        }
};
int sum(NodeTree * root){
        if(!root) return 0;

        int l = sum(root->left);
        int r = sum(root->right);
        return l + r + root->val;
    }
NodeTree* insert(void)
{
    int i;
    cin>>i;
    NodeTree * root = NULL;

    if(i==-1) return root;

    root = new NodeTree(i);
    queue<NodeTree*>qu;
    qu.push(root);
   
    while(!qu.empty())
    {
        //take
        NodeTree * p = qu.front();
        qu.pop();

        //opration
        int l, r;
        cin>>l>>r;
        NodeTree* myLeft;
        NodeTree * myRight;
        if(l==-1) 
            myLeft =NULL;
        else 
            myLeft= new NodeTree(l);
        if(r==-1) 
            myRight = NULL;
        else 
            myRight= new NodeTree(r);

        p->left = myLeft;
        p->right = myRight;

        //insertion
        if(p->left)
            qu.push(p->left);
        if(p->right)
            qu.push(p->right);
    }
    return root;
}
int main(){

    NodeTree * root = insert();
    cout<<sum(root)<<endl;
    

return 0;
}