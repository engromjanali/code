//     10 20 30 -1 // input
//     7 //Quary
//     //Input:    Output:
//     1 40        10 40 20 30
//     5 50        Invalid
//     4 50        10 40 20 30 50
//     0 100       100 10 40 20 30 50
//     7 40        Invalid
//     1 110       100 110 10 40 20 30 50
//     7 40        100 110 10 40 20 30 50 40


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
void insert_in_tail(Node *& head,int V)
{
    Node * temp = head;
    Node * newNode = new Node(V);
    if(head==NULL)
    {
        head= newNode;
        return;
    }
    while(temp->next!=NULL)
    {
        temp = temp->next;
    }
    temp->next= newNode;
}
void insert_in_position(Node *& head,int P,int  V, bool & flag)
{
    Node * temp = head;
    Node * newNode = new Node(V);
    if(P==0)
    {
        newNode->next=head;
        head=newNode;
        return;
    }
    for(int i=0; i<P-1; i++)
    {
        if(temp->next==NULL)
        {
            flag=false;
            return;
        }
        temp=temp->next;
    }
    newNode->next=temp->next;
    temp->next= newNode;
}
void print_link_list(Node * head)
{
    if(head== NULL) return;
    Node * temp = head;
    while (temp!=NULL)
    {
        cout<<temp->val<<" ";
        temp= temp->next;
    }
    cout<<endl;
}
int main(){

    Node * head = NULL;
    while(true){
        int V;
        cin>>V;
        if(V==-1)
        {
            break;
        }
        insert_in_tail(head, V);
    }

    int Q;
    cin>>Q;
    while (Q--)
    {
        int I,V;
        cin>>I>>V;
        bool flag = true;
        insert_in_position(head, I, V, flag);
        if(flag) print_link_list(head);
        else cout<<"Invalid"<<endl;
    }

return 0;
}