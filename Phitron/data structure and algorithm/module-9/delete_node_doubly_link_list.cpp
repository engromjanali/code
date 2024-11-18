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
void insert_at_head(Node *&head, Node *&tail, int val)
{
    Node *newNode = new Node(val);
    if (head == NULL)
    {
        head = newNode;
        tail = newNode;
        return;
    }
    newNode->next = head;
    head->prev = newNode;
    head = newNode;
}
void insert_at_tail(Node *&head, Node *&tail, int val)
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
void delete_head(Node * & head, Node * & tail)
{
    if(head==tail)
    {
        delete head;
        head = NULL;
        tail = NULL;
        return;
    }
    Node * deleteNode = head;
    head=head->next;
    head->prev=NULL;
    delete deleteNode;
}
void delete_tail(Node * & head, Node * & tail)
{ 
    if(head==tail)// it's valid with hendel error(null pointer)
    {
        delete head;//valid
        head = NULL;
        tail = NULL;
        return;
    }
    Node * deleteNode = tail;
    tail=tail->prev;
    tail->next=NULL;
    delete deleteNode;
}
void delete_position(Node * & head, Node * & tail, int P)
{
    if(head==tail )
    {
        if(P==0)
        {
            delete head;
            head = NULL;
            tail = NULL;
            return;
        }
        return;
    }
    if(P==0)
    {
        Node * deleteNode = head;
        head=head->next;
        head->prev=NULL;
        delete deleteNode;
        return;
    }
    Node * temp = head;
    for(int i=0; i<P-1; i++)
    {
        if(temp->next->next ==NULL) return;
        temp = temp->next;
    }
    Node * deleteNode = temp->next;
    temp->next=temp->next->next;
    if(temp->next==NULL) tail = temp;
    else temp->next->prev=temp;
    delete deleteNode;
}
void print_normal(Node *head)
{
    Node *tmp = head;
    while (tmp != NULL)
    {
        cout << tmp->val << " ";
        tmp = tmp->next;
    }
    cout << endl;
}
void print_reverse(Node *tail)
{
    Node *tmp = tail;
    while (tmp != NULL)
    {
        cout << tmp->val << " ";
        tmp = tmp->prev;
    }
    cout << endl;
}
int main(){
    Node * head = NULL;
    Node * tail = NULL;
    int V;
    while(true)
    {
        cin>>V;
        if(V==-1) break;
        insert_at_tail(head,tail,V);
    }
    print_normal(head);
    // print_reverse(tail);

    // delete_head(head,tail);
    // delete_tail(head,tail);
    while(true)
    {
        int P;
        cin>>P;
        if(P==-1) break;
        delete_position(head,tail,P);
    }
    print_normal(head);
    // print_reverse(tail);

return 0;
}