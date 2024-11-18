#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
        int val;
        Node * next;
        Node(int val){
            this->val=val;
            next=NULL;
        }
};

void insert_in_tail(Node *& head, int v)
{ 
    Node * newNode = new Node(v); 
    if(head==NULL)
    {
        head=newNode;
        return;
    }
    Node * temp = head;
    while(temp->next!=NULL)
    {
        temp=temp->next;
    }
    temp->next=newNode;
}
void delete_head(Node *&head)
{
    if(head==NULL){
        cout<<"head dose not exist!";
        return;
    }
    
    Node* deleteNode= head;
    head = head->next;
    delete deleteNode;
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

void insert_in_head(Node *& head, int V)
{
    Node * newNode = new Node(V);

    newNode->next=head;
    head = newNode;
    cout<<"Inserted in head!"<<endl;
}

int main(){
    Node * head = NULL;
    int N=5;
    while(N--)
    {
        int V;
        cin>>V;
        insert_in_tail(head,V);
    }
    
    delete_head(head);
    print_link_list(head);
    return 0;
}