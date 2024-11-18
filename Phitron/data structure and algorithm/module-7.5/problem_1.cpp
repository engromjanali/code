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

void insert_in_tail(Node * & head, Node *& tail, int v)
{
    Node * newNode = new Node(v);
    if(head==NULL)
    {
        head=newNode;
        tail=newNode;
        return;
    }
    tail->next = newNode;
    tail = newNode;
}

int size_of_link_list(Node * head)
{
    int count=0;
    if(head==NULL) return count;
    while(head!=NULL)
    {
        head=head->next;
        count++;
    }
    return count;
}
int main(){

    // Link List - 1
    Node * head = NULL;
    Node * tail = NULL;
    // Link List - 2
    Node * head2 = NULL;
    Node * tail2 = NULL;

    while(true)
    {
        int a;
        cin>>a;
        if(a==-1)
        {
            break;
        }
        insert_in_tail(head,tail,a);
    }

    while(true)
    {
        int a;
        cin>>a;
        if(a==-1)
        {
            break;
        }
        insert_in_tail(head2,tail2,a);
    }
    if(size_of_link_list(head)!=size_of_link_list(head2)){
        cout<<"NO"<<endl;
    }
    else cout<<"YES"<<endl;

    

return 0;
}