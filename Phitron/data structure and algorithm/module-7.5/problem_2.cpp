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
void insert_in_tail(Node *&head, Node *& tail, int V)
{
    Node * newNode = new Node(V);
    if(head==NULL)
    {
        head = newNode;
        tail = newNode;
    }
    tail->next=newNode;
    tail= newNode;
}
void reverse_order(Node * head)
{
    if(head==NULL) return;
    reverse_order(head->next);
    cout<<head->val<<" ";
}
int main(){
    Node * head= NULL;
    Node * tail = NULL;

    while(true)
    {
        int V;
        cin>>V;
        if(V==-1)
        {
            break;
        }
        insert_in_tail(head,tail,V);
    }
    reverse_order(head);

return 0;
}