// rule of level order traversal

// at fast root will be inserted in a queue 
// root will print and it's child node will be inserted in queue 
// folowing that every parent print himself and insert it's children Node.



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
void level_order(Node * root)
{
    queue <Node*> qu;
    qu.push(root);

    while (!qu.empty())
    {
        Node * a = qu.front();
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
int main(){

    Node * root = new Node(10);
    Node * a = new Node(20);
    Node * b = new Node(30);
    Node * c = new Node(40);
    Node * d = new Node(50);
    Node * e = new Node(60);
    Node * f = new Node(70);
    Node * g = new Node(80);
    Node * h = new Node(90);
    Node * i = new Node(100);

    root->left = a;
    root->right = b;
    a->left = c;
    a->right = d;
    b->right = e;
    c->left  = f;
    c->right = g;
    f->right = h;
    g->left = i;

    // root = NULL;
    
    level_order(root);
return 0;
}