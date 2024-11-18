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

void insert_in_tail(Node *& head, Node *& tail, int V)
{
    Node * newNode = new Node(V);
    if(head==NULL)
    {
        head = newNode;
        tail = newNode;
        return;
    }
    tail->next = newNode;
    tail= newNode;
}

void sort_link_list(Node * head)
{
    for(Node * i = head; i->next != NULL; i=i->next)
    {
        for(Node * j = i->next; j != NULL; j=j->next)
        {
            if(i->val > j->val)
            {
                swap(i->val,j->val);
            }
        }
    }
}

void print_link_list(Node * head)
{
    if(head==NULL)
    {
        return;
    }
    while(head!=NULL)
    {
        cout<<head->val<<" ";
        head=head->next;
    }
}
int main(){

    Node * head = NULL;
    Node * tail = NULL;

    int V;
    while(true)
    {
        cin>>V;
        if(V==-1)
        {
            break;
        }
        insert_in_tail(head,tail,V);
    }
    

    sort_link_list(head);
    cout<<tail->val<<" ";
    cout<<head->val<<" ";

return 0;
}