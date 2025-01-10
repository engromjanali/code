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
void insert_at_position(Node *& head, Node *& tail, int pos, int val)
{
    Node *newNode = new Node(val);
    Node *tmp = head;
    // for head.
    if(head == NULL)
    {
        if(pos == 0)
        {
            head = new Node(val);
            tail = head;
        }
        return;
    }
    if(pos == 0)
    {
        newNode->next = head;
        head->prev = newNode;
        head = newNode;
        return;
    }
    //for tail.
    if(!head) return; // it's for if (head == NULL) but we want to trying to insert value in 1 or N position. it hendel.
    for (int i = 1; i < pos; i++)
    {
        if(tmp->next == NULL) return;// index out of bounds handeled.
        tmp = tmp->next;
    }
    newNode->next = tmp->next; 
    newNode->prev = tmp;          
    tmp->next = newNode;
    if(tmp->next->next==NULL) tail=newNode;
    else newNode->next->prev=newNode; 
}
int main(){
    int siz = 0;
    Node * head = NULL;
    Node * tail = NULL;
    int q; cin>>q;
    while(q--)
    {
        int x,v;
        cin>>x>>v;
        if(x>siz)
        {
            cout<<"Invalid"<<endl;
        }
        else{
            insert_at_position(head,tail,x,v);
            cout<<"L -> "; print_forword(head);
            cout<<endl;
            cout<<"R -> ";print_reverse(tail);
            cout<<endl;
            siz++;
        }
    }

return 0;
}