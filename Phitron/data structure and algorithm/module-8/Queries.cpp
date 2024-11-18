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

void insert_in_head(Node * & head, Node *& tail, int V)
{
    Node * newNode = new Node(V);
    if(head == NULL)
    {
        head = newNode;
        tail = newNode;
        return;
    }
    newNode->next = head;
    head = newNode;
}
void insert_in_tail(Node * & head, Node *& tail, int V)
{
    Node * newNode = new Node(V);
    if(head == NULL)
    {
        head = newNode;
        tail = newNode;
        return;
    }
    tail->next = newNode;
    tail = newNode;
}
int main(){
    Node * head= NULL;
    Node * tail = NULL;

    int v;
    cin>>v;
    while (v--)
    {
        int  P,V;
        cin>>P>>V;

        if(P==0)
        {
            insert_in_head(head, tail, V);
        }
        else insert_in_tail(head,tail,V);

        cout<<head->val<<" ";
        cout<<tail->val<<" ";
    }
    
return 0;
}