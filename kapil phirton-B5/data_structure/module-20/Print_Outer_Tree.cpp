

#include<bits/stdc++.h>
using namespace std;
class Node{
    public :
        int val;
        Node * left;
        Node * right;
        Node(int val)
        {
            this->val=val;
            left  = NULL;
            right = NULL;
        }
};

Node* level_order_input_binary_tree(void)
{
    int i;
    cin>>i;
    Node * root = NULL;

    if(i==-1) return root;

    root = new Node(i);
    queue<Node*>qu;
    qu.push(root);
   
    while(!qu.empty())
    {
        //take
        Node * p = qu.front();
        qu.pop();

        //opration
        int l, r;
        cin>>l>>r;
        Node* myLeft;
        Node * myRight;
        if(l==-1) 
            myLeft =NULL;
        else 
            myLeft= new Node(l);
        if(r==-1) 
            myRight = NULL;
        else 
            myRight= new Node(r);

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

void print_l(Node * root)
{
    if(!root) return;
    print_l(root->left);
    if(!root->left)
    {
        print_l(root->right);
    }
    cout<<root->val<<" ";
}
void print_r(Node * root)
{
    if(!root) return;
    cout<<root->val<<" ";
    print_r(root->right);
    if(!root->right)
    {
        print_r(root->left);
    }
}


int main(){

    Node * root = level_order_input_binary_tree();
    if(root){
        Node * left = root->left;
        Node * right = root->right;
        print_l(left);
        cout<<root->val<<" ";
        print_r(right);
    }

return 0;
}