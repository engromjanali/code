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
bool compare_two_list(Node * head1, Node * head2)
{
    bool flge = false;
    if(size_of_link_list(head1) != size_of_link_list(head2)) return flge;
    while(head1!=NULL)
    {
        if(head1->val != head2->val)
        {
            
            return flge;
        }
        head1= head1->next;
        head2= head2->next;
    }
    return true;
}

void copy_link_list(Node * head, Node *& head2, Node *& tail2)
{
    while(head != NULL)
    {
        insert_tail(head2,tail2,head->val);
        head = head->next;
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

    while(true)
    {
        int a ;
        cin>>a;
        if(a==-1) break;
        insert_tail(head,tail,a);
    }
    Node * head2 = NULL;
    Node * tail2 = NULL;

    copy_link_list(head,head2,tail2);
    reverse_doubly_link_list_loop(head2,tail2);
    if(compare_two_list(head, head2)) cout<<"YES"<<endl;
    else cout<<"NO"<<endl;

return 0;
}