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

int main(){

    // fast list
    Node * head = NULL;
    Node * tail = NULL;
    while (true)
    {
        int a;
        cin>>a;
        if(a==-1) break;
        insert_tail(head, tail, a);
    }

    //2nd list
    Node * head2 = NULL;
    Node * tail2 = NULL;
    while (true)
    {
        int a;
        cin>>a;
        if(a==-1) break;
        insert_tail(head2, tail2, a);
    }

    if(compare_two_list(head, head2)) cout<<"YES"<<endl;
    else cout<<"NO"<<endl;
return 0;
}