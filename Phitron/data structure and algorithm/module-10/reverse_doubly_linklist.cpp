// reverese doubly link list
// ai babe korla amra kuno exception pabo na. value kom takle ba na takle-o exception asbe na. 
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
    tail = tail->next; // or tail = newNode;
}

void print_forword(Node * n)
{
    if(n == NULL) return;
    cout<<n->val<<" ";
    print_forword(n->next);
}

void reverse_doubly_link_list(Node * head, Node * tail) // way 1
{
    if( head == tail || head->prev==tail) return; // note : we have to write 1st condition (head == tail) and 2nd condition (head->prev==tail).
    
    cout<<head->val<<" "<<tail->val<<endl;
    int temp = head->val;
    head->val=tail->val;
    tail->val=temp;
    
    reverse_doubly_link_list(head->next, tail->prev);
}
void reverse_doubly_link_list_loop(Node * head, Node * tail)// way 2
{
    Node * i = head;
    Node * j = tail;

    while( i!=j && i->prev != j )// note : we have to write 1st condition (i !=j) and 2nd condition (prev != j).
    {
        swap(i->val,j->val);
        i=i->next;
        j=j->prev;
    }
}
int main(){

    Node * head=NULL;
    Node * tail=NULL;

    while(true)
    {
        int v;
        cin>>v;
        if(v==-1) break;
        insert_at_tail(head,tail,v);
    }

    // reverse_doubly_link_list(head,tail); //way 1
    reverse_doubly_link_list_loop(head,tail); // way 2
    print_forword(head);
    cout<<endl;

return 0;
}