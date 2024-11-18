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

void reverse_doubly_link_list(Node * head, Node * tail) // way 1
{
    if( head == tail || head->prev==tail) return; // note : we have to write 1st condition (head == tail) and 2nd condition (head->prev==tail).
    
    // cout<<head->val<<" "<<tail->val<<endl;
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

void print_forword(Node * n)
{
    if(n == NULL) return;
    cout<<n->val<<" ";
    print_forword(n->next);
}

int main(){

    Node * head = NULL;
    Node * tail = NULL;
    while (true)
    {
        int a;
        cin>>a;
        if(a==-1) break;
        insert_tail(head, tail, a);
    }
    reverse_doubly_link_list(head,tail);
    print_forword(head);

return 0;
}