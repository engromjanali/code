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
        tail = newNode;
        return;
    }
    tail->next=newNode;
    tail = newNode;
}
int size_of_link_list(Node * head)
{
    int count=0;
    if(head==NULL) return count;
    while(head!=NULL)
    {
        head=head->next;
        count++;
    }
    return count;
}
void print_position(Node * head, int p)
{
    if(head==NULL){
        return;
    }
    for(int i=0; i<p; i++)
    {
        head=head->next;
    }
    cout<<head->val<<" ";
}
void sort_link_list(Node * head)
{
    for(Node * i = head; i->next != NULL; i=i->next)
    {
        for(Node * j = i->next; j != NULL; j=j->next)
        {
            if(i->val < j->val)
            {
                swap(i->val,j->val);
            }
        }
    }
}

void print_link_list(Node * head)
{
    while(head != NULL)
    {
        cout<<head->val<<" ";
        head = head->next;
    }
}

void reverse_order(Node * n)
{
    if(n == NULL) return;
    reverse_order(n->next);
    cout<<n->val<<" ";
}
int main(){
    Node * head= NULL;
    Node * tail = NULL;
    print_link_list(head);
    while ((true))
    {
        int v;
        cin>>v;
        if(v==-1)
        {
            break;
        }
        insert_in_tail(head,tail,v);
    }
    reverse_order(head);
    cout<<endl;
    print_link_list(head);

    
    
return 0;
}