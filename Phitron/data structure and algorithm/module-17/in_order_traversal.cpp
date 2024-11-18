// roul of traversal as in_order
// 1.  print left
// 2.  print self
// 3.  print right



//                 10
//             20       30 
//         40      50 60
//     70      80
// 90        100

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
void pre_order(Node * root)
{
    if(root == NULL) return; // base case;
    
    pre_order(root->left);
    cout<< root ->val <<" ";
    pre_order(root->right);
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

    pre_order(root);
return 0;
}