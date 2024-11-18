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

NodeTree* level_input(void)
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

void level_output(NodeTree * root)
{
    queue <NodeTree*> qu;
    qu.push(root);

    while (!qu.empty())
    {
        NodeTree * a = qu.front();
        qu.pop();
        if(!a);
        else
        { 
            cout<<a->val<<" ";
            if(a->left) qu.push(a->left);
            if(a->right) qu.push(a->right);
        }
    }
}

bool search(NodeTree * root, int v)
{
    if(root == NULL) return false;
    if(root->val == v) return true;
    if(root->val < v)
    {
        return search(root->right, v);
    }
    else{
        return search(root->left, v);
    }
}

void insert_in_bst(NodeTree *& root , int v)
{
    if(root == NULL) 
    {
        root = new NodeTree(v);
    }
    else if(root->val > v)
    {
        insert_in_bst(root->left, v);
    }
    else insert_in_bst(root->right,v);
}
int main(){

    NodeTree * root = NULL;
    root = level_input();
    insert_in_bst(root, 100);
    level_output(root);
    cout<<endl;
    if(search(root,25)) cout<<"Yes";
    else cout<<"No";
    

return 0;
}