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
void insert_tail(Node *&  head, Node *& tail, int v)
{
    Node * newNode = new Node ( v);
    if( head == NULL)
    {
        head = newNode;
        tail = newNode;
        return;
    }
    tail->next = newNode;
    tail = tail->next;
}
void sort_list(Node * head)
{
    for(Node * i = head; i->next != NULL; i=i->next)
    {
        for(Node * j = i->next; j!=NULL; j=j->next )
        {
            if(i->val>j->val){
                swap(i->val,j->val);
            }
        }
    }
}
void unique_list(Node*head, Node *& tail)
{
    while ((head !=NULL && head->next !=NULL))
    {
        if(head->val==head->next->val)
        {
            Node * deleteNode =head->next;
            head->next = head->next->next;
            if(deleteNode == tail) tail = head;
            delete deleteNode;
        }
        else head = head->next;
    }
}
int main(){
    Node * head = NULL;
    Node * tail = NULL;

    while (true)
    {
        int a;
        cin>>a;
        if(a==-1) break;
        insert_tail(head,tail,a);
    }
    sort_list(head);
    unique_list(head,tail);
    while(head != NULL)
    {
        cout<<head->val<<" ";
        head = head->next;
    }
return 0;
}