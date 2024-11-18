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

void reverse_singly(Node *& head, Node * cur) //O(N).
{
    if(head == NULL || cur->next == NULL)
    {
        head = cur;
        return;
    }
    reverse_singly(head,cur->next);
    cur->next->next= cur;
    cur->next = NULL;
}

void print_forword(Node * n)
{
    if(n == NULL) return;
    cout<<n->val<<" ";
    print_forword(n->next);
}

int main(){

    Node * head = new Node(10);
    Node * a = new Node(20);
    Node * b = new Node(30);
    Node * c = new Node(40);

    head->next=a;
    a->next=b;
    b->next=c;
    c->next=NULL; 

    b->next= NULL;


    reverse_singly(head, head);    
    print_forword(head);

return 0;
}