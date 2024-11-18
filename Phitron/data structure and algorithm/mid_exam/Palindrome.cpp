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
void reverse_singly(Node *& head, Node * cur) //O(N).
{
    if(head == NULL || cur->next == NULL)
    {
        head = cur;
        return;
    }
    reverse_singly(head,cur->next);
    cur->next->next= cur;
    cur->next = NULL;
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
bool compare_two_list(Node * head1, Node * head2){
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
void copy_list(Node * head, Node*& head1, Node*&tail1)
{
    while (head != NULL)
    {
        insert_tail(head1, tail1, head->val);
        head = head->next;
    }
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
    Node * head1 = NULL;
    Node * tail1 = NULL;
    copy_list(head,head1,tail1);
    reverse_singly(head1,head1);
    if(compare_two_list(head,head1))
    {
        cout<<"YES"<<endl;
    }
    else cout<<"NO"<<endl;

return 0;
}