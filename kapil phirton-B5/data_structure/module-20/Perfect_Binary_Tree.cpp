

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

bool perfect(Node * root)
{
    if(!root) return true;
    if(root->left && !root->right) return false; 
    if(!root->left && root->right) return false; 
    

    bool left = perfect(root->left);
    bool right = perfect(root->right);

    if(left && right) return true;
    else return false;
}
int main(){

    Node * root = level_order_input_binary_tree();
    if(perfect(root)) cout<<"YES"<<endl;
    else cout<<"NO";

return 0;
}