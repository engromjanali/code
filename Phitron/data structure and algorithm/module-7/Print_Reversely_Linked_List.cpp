// reverese print link list
#include<bits/stdc++.h>
using namespace std;
class Node{
    public :
        int val;
        Node * next;
        Node(int val)
        {
            this->val=val;
            next=NULL;
        }
};
void insert_in_tail(Node *& head, Node *& tail, int v)
{
    Node * newNode = new Node(v);
    if(head==NULL)
    {
        head=newNode;
        tail=newNode;
        return;
    }
    tail->next=newNode;
    tail=newNode;
}
void print_forword(Node * n)
{
    if(n == NULL) return;
    cout<<n->val<<" ";
    print_forword(n->next);
}
void print_reverse(Node * n)  // reverse order
{
    if(n == NULL) return;
    print_reverse(n->next);
    cout<<n->val<<" ";
}

int main(){

    Node * head=NULL;
    Node * tail=NULL;
    while(true)
    {
        int v;
        cin>>v;
        if(v==-1) break;
        insert_in_tail(head,tail,v);
    }
    print_forword(head);
    cout<<endl;
    print_reverse(head);

return 0;
}