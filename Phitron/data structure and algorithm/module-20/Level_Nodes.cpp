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

vector<int> level_order(Node * root, int l)
{
    vector<int> res;
    queue <pair<Node *, int>> qu;
    qu.push({root, 0});

    while (!qu.empty())
    {
        pair<Node * , int> p=qu.front();
        Node * a= p.first;
        int level = p.second;
        qu.pop();
        
        if(!a);
        else
        { 
            if(level == l) res.push_back(a->val);
            
            if(a->left) qu.push({a->left, level+1});
            if(a->right) qu.push({a->right, level+1});
        }
    }
    return res;
}


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
int main(){

    Node * root = level_order_input_binary_tree();
    int l;
    cin>>l;

    vector<int>v = level_order(root, l);

    if(v.empty()) cout<<"Invalid"<<endl;
    else 
    {
        for(auto it = v.begin(); it<v.end(); it++)
        {
            cout<<* it<<" ";
        }
    }
return 0;
}