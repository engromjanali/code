// Take a singly linked list as input and check if the linked list is sorted in ascending order. output YES/NO
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

void check_order(Node * head, bool & flag)
{
    if(head== NULL) return;
    Node * temp = head;
    while (temp->next!=NULL)
    {
        if(temp->val > temp->next->val ) flag= false;
        // cout<<temp->val<<" "<<temp->next->val<<endl;
        temp=temp->next;
    }
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

    bool flag = true;
    check_order(head, flag);
    if(flag) cout<<"YES";
    else cout<<"NO"<<endl;
    
return 0;
}