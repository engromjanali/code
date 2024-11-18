#include<bits/stdc++.h>
using namespace std;
class Node{
    public :
        int val;
        Node * next;

        Node(int val)
        {
            this->val=val;
            this->next=NULL;
        }
};
void insert_in_tail(Node *& head, int v)
{ 
    Node * newNode = new Node(v); 
    if(head==NULL)
    {
        head=newNode;
        cout<<"inserted in Head!"<<endl;
        return;
    }
    Node * temp = head;
    while(temp->next!=NULL)
    {
        temp=temp->next;
    }
    temp->next=newNode;
}
void print_link_list(Node * head)
{
    cout<<"Your Link List : ";
    while(head!=NULL)
    {
        cout<<head->val<<" ";
        head = head->next;
    }
    cout<<endl;
}
void insert_in_any_position(Node * &head, int P, int V)
{
    Node * newNode = new Node(V);
    if(P==0)
    {
        newNode->next=head;
        head = newNode;
        cout<<"Inserted in head!";
        return;
    }
    Node * temp = head;
    for(int i=0; i<P-1; i++)
    {
        temp=temp->next;
    }
    newNode->next = temp->next;
    temp->next = newNode;
    cout<<"Inserted in "<<P<<"position.";
}
void insert_in_head(Node *& head, int V)
{
    Node * newNode = new Node(V);

    newNode->next=head;
    head = newNode;
    cout<<"Inserted in head!"<<endl;
}

int main(){

    Node * head=NULL;
    while(true){
        cout<<"Option 0: Insert in Tail."<<endl;
        cout<<"Option 1: Print Link List."<<endl;
        cout<<"Option 2: insert in any position."<<endl;
        cout<<"Option 3: terminate."<<endl;
        cout<<"Option 4: Insert in Head."<<endl;
        int Q;
        cin>>Q;
        if(Q==0){
            int V;
            cin>>V;
            insert_in_tail(head, V);
        }
        else if(Q==1)
        {
            print_link_list(head);
        }
        else if(Q==2)
        {
            int P, V;
            cout<<"Enter Your Position : ";
            cin>>P;
            cout<<"Enter Your Value : ";
            cin>>V;
            insert_in_any_position(head,P,V);
        }
        else if(Q==3)
        {
            break;
        }
        else if(Q==4)
        {
            int v;
            cin>>v;
            insert_in_head(head,v);
        }
    }

return 0;
}