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


// delete any position of node with handeling eny type of exception. for unwanted position the fonction done nothing.
void delete_position(Node *& head, Node*& tail, int p){//p mean index
    if(head==NULL || p <0){// there are no element or position negitive.
        return;
    }

    if(p==0){
        if(head==tail)// there are one element and we are delete it, so head,tail will be NULL.
        {
            delete head;
            head = NULL;
            tail = NULL;
            return;
        }
        else{
            Node * deleteNode = head;
            head = head->next;
            delete deleteNode;
            return;
        }
    }
    
    if(p==1){
        if(head == tail){// there are only one element
            return;
        }
        if(head->next==tail) //there are 2 element
        {
            delete tail;
            head->next = NULL;
            tail= head;
            return;
        }
        else{
            Node * deleteNode = head->next;
            head->next = head->next->next;//joining the two part.
            delete deleteNode;
            return;
        }
    }

    Node * temp = head;
    for(int i =2; i<=p; i++)// going pre index of delete index.
    {
        if(temp->next == NULL)
        {
            return; // hendel unwanted exception.
        }
        temp = temp->next;// incrementing position.
    }
    if(temp==tail){// if pre index is tail. that's mean we are going to delete NULL.
        return;
    }
    if(temp->next == tail){// if next index of preindex is equal tail that's mean we are going to delete tail.
        tail = temp; // temp is pre index of tail. 
    }
    Node * deleteNode = temp->next;
    temp->next=temp->next->next;//joining two part.
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

void insert_in_head(Node *& head,Node *& tail, int V)
{
    
    Node * newNode = new Node(V);
    if(head = NULL)
    {
        head = newNode;
        tail = newNode;
    }
    
    newNode->next=head;
    head = newNode;
    cout<<"Inserted in head!"<<endl;
}
void insert_in_tail(Node *& head,Node *& tail, int v)
{ 
    Node * newNode = new Node(v); 
    if(head==NULL)
    {
        head=newNode;
        tail= newNode;
        return;
    }
    tail->next = newNode;
    tail= newNode;
}

int main(){
    Node * head = NULL;
    Node * tail = NULL;
    int N=5;
    while(N--)
    {
        int V;
        cin>>V;
        insert_in_tail(head,tail,V);
    }
    cout<<"Enter position number here what you want to delete : ";
    int P;
    cin>>P;
    delete_position(head,tail,P);
    print_link_list(head);
    return 0;
}