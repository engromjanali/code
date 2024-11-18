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


NodeTree * convert(int a[], int n, int l, int r)
{
    if(l > r) return NULL;
    int mid = (l+r)/2;
    NodeTree * root = new NodeTree(a[mid]);
    NodeTree * leftroot = convert(a,n,l,mid-1);
    NodeTree * rightroot = convert(a,n,mid+1,r);
    root -> left = leftroot;
    root -> right = rightroot;
    return root;
}
int main(){
    int a[]={2,5,8,12,15,18};
    NodeTree * root = convert(a, sizeof(a)/a[0], 0, sizeof(a)/4-1);
    level_output(root);
return 0;
}