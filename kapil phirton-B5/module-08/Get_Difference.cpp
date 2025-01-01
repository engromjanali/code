#include<bits/stdc++.h>
using namespace std;
int mn = INT_MAX;
int mx = INT_MIN;
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


void print(Node * head)
{
    while(head != NULL)
    {
        if(mn>head->val) mn = head->val;
        if(mx<head->val) mx = head->val;
        head= head->next;
    }
}

int main(){
    Node * head= NULL;
    Node * tail = NULL;

    while (true)
    {
        int  V;
        cin>>V;
        if(V==-1) break;
        insert_in_tail(head, tail, V);    
    }

    print(head);
    cout<<mx-mn;
    
return 0;
}