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

void insert_in_tail(Node *& head, Node *& tail, int V)
{
    Node * newNode = new Node(V);
    if(head==NULL)
    {
        head = newNode;
        tail = newNode;
        return;
    }
    tail->next = newNode;
    tail= newNode;
}

bool check_same_size_or_not(Node * head, Node * head2)
{
    bool flg = false;
    int count1=0;
    int count2=0;
    while(head!= NULL)
    {
        count1++;
        head= head->next;
    }
    while(head2!= NULL)
    {
        count2++;
        head2= head2->next;
    }
    if(count1==count2)
    {
        flg = true;
    }
    return flg;
}
bool check_same_value_or_not(Node * head,Node * head2){
    bool flg = true;

    while(head!=NULL && head2 != NULL)
    {        
        if(head->val!=head2->val){
            flg = false;
            break;
        }
        head =  head->next;
        head2 = head2->next;
    }

    return flg;
}
int main(){

    Node * head = NULL;
    Node * tail = NULL;
    Node * head2 = NULL;
    Node * tail2 = NULL;

    int V;
    while(true)
    {
        cin>>V;
        if(V==-1)
        {
            break;
        }
        insert_in_tail(head,tail,V);
    }
    while(true)
    {
        cin>>V;
        if(V==-1)
        {
            break;
        }
        insert_in_tail(head2,tail2,V);
    }

    if(check_same_size_or_not(head,head2))
    { 
        if(check_same_value_or_not(head,head2))
        {
            cout<<"YES"<<endl;
        }
        else cout<<"NO"<<endl;
    }
    else cout<<"NO"<<endl;


return 0;
}