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

void insert_in_tail(Node *&head, int val)
{        
    if(head==NULL)
    {
        Node * newNode = new Node(val);
        head=newNode;
        return;
    }
    Node * temp = head;
    while(temp->next!=NULL)
    {
        temp= temp->next;
    }
    Node * newNode = new Node(val);
    temp->next=newNode;
}

void print_link_list(Node* head)
{
    Node * temp = head;
    if(temp==NULL)
    {
        return;
    }
    while(temp!=NULL)
    {
        cout<<temp->val<<" ";
        temp= temp->next;
    }
}
void count_element_of_link_list(Node* head)
{
    Node * temp = head;
    if(temp==NULL)
    {   
        return;
    }
    int count=0;
    while(temp!=NULL)
    {
        count++;
        temp= temp->next;
    }
    cout<<count;
}
int main(){

    Node * Head=NULL;
    while(true)
    {    
        int a=1;
        cin>>a;
        if(a==-1) break;
        insert_in_tail(Head, a);
    }
    count_element_of_link_list(Head);

return 0;
}