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
int main(){
    Node * head= NULL;
    Node * tail = NULL;
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
    if(size_of_link_list(head)%2==0)
    {
        print_position(head,size_of_link_list(head)/2-1);
        print_position(head,size_of_link_list(head)/2);
    }
    else{
        print_position(head,size_of_link_list(head)/2);
    }
return 0;
}