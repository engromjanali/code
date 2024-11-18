#include<bits/stdc++.h>
using namespace std;
class Node{
    public :
        int val;
        Node * next;
        Node * prev;
        Node(int val)
        {
            this->val=val;
            next=NULL;
            prev=NULL;
        }
};

int size_of_link_list(Node * head)
{
    int res=0;
    while(head!=NULL)
    {
        res++;
        head = head->next;
    }
    return res;
}

void sort_link_list(Node* head)
{
    Node * i = NULL;
    Node * j = NULL; 
    for(i=head; i->next != NULL; i=i->next)
    {
        for(j = i->next; j != NULL; j=j->next)
        {
            if(i->val > j->val) swap(i->val,j->val);
        }
    }
}
void print_forword(Node * n)
{
    if(n == NULL) return;
    cout<<n->val<<" ";
    print_forword(n->next);
}

void print_reverse(Node * n)
{
    if(n == NULL) return;
    cout<<n->val<<" ";
    print_reverse(n->prev);
}

void insert_tail(Node *&head, Node *&tail, int val)
{
    Node *newNode = new Node(val);
    if (tail == NULL)
    {
        head = newNode;
        tail = newNode;
        return;
    }
    tail->next = newNode;
    newNode->prev = tail;
    tail = tail->next;
}
int main(){

    Node * head = NULL;
    Node * tail = NULL;

    while(true)
    {
        int v;
        cin>>v;
        if(v==-1) break;
        insert_tail(head,tail,v);
    }

    sort_link_list(head);
    print_forword(head);

return 0;
}