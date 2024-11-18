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
void insert_in_tail(Node *& head, int v) //it's complexity O(N)
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
void insert_in_tail_2(Node *& head,Node * & tail, int v)// with tail pointer. it's complexity O(1)
{ 
    Node * newNode = new Node(v); 
    if(head==NULL)
    {
        head=newNode;
        tail=newNode;
        cout<<"inserted in Head!"<<endl;
        return;

    }
    tail->next=newNode;
    tail=newNode;
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
int main(){

    Node * head=NULL;
    while(true){
        cout<<"Option 0: Insert in Tail."<<endl;
        cout<<"Option 1: Print Link List."<<endl;
        cout<<"Option 2: terminate."<<endl;
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
            break;
        }
    }

return 0;
}