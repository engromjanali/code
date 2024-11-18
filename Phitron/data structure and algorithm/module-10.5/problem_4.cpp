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

void insert_at_position(Node *& head, Node *& tail, int pos, int val)
{
    Node *newNode = new Node(val);
    Node *tmp = head;
    // for head.
    if(pos==0){
        newNode->next=head;
        head=newNode;
        if(head->next==NULL)
        {
            tail = newNode;
        } 
        else{
            head->next->prev=newNode;
        }
        return;
    }
    
    //for tail.
    for (int i = 1; i <= pos - 1; i++)
    {
        if(tmp->next == NULL) break;// index out of bounds handeled.
        tmp = tmp->next;
    }
    newNode->next = tmp->next; 
    newNode->prev = tmp;          
    tmp->next = newNode;
    if(tmp->next->next==NULL) tail=newNode;
    else newNode->next->prev=newNode;      
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


int main(){

    Node * head = NULL;
    Node * tail = NULL;
    int N;
    cin>>N;
    while(N--)
    {
        int x, v;
        cin>>x>>v;
        if(x>size_of_link_list(head))
        {
            cout<<"Invalid"<<endl;
        }
        else 
        {
            insert_at_position(head,tail,x,v);
            cout<<"L -> ";
            print_forword(head);
            cout<<endl;
            cout<<"R -> ";
            print_reverse(tail);
            cout<<endl;
        }
    }

return 0;
}