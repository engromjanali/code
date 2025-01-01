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


int finding(Node * head, int x)
{

    if(head!=NULL && head->val==x) return 0;
    int i =1;
    while(head->next != NULL)
    {
        if(head->next->val==x) return i;
        head= head->next;
        i++;
    }
    return -1;
}
int main(){

    int t; cin>>t;
    while(t--)
    {
        Node * head=  NULL;
        Node * tail = NULL;

        while (true)
        {
            int  V;
            cin>>V;
            if(V==-1) break;
            insert_in_tail(head, tail, V);    
        }
        int x ; cin>>x;
        cout<<finding(head,x)<<endl;
    }

return 0;
}