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
void insert_tail(Node *&  head, Node *& tail, int v)
{
    Node * newNode = new Node ( v);
    if( head == NULL)
    {
        head = newNode;
        tail = newNode;
        return;
    }
    tail->next = newNode;
    tail = tail->next;
}
void sort_list(Node * head)
{
    for(Node * i = head; i->next != NULL; i=i->next)
    {
        for(Node * j = i->next; j!=NULL; j=j->next )
        {
            if(i->val>j->val){
                swap(i->val,j->val);
            }
        }
    }
}
void unique_list(Node*head, Node *& tail)
{
    while ((head !=NULL && head->next !=NULL))
    {
        if(head->val==head->next->val)
        {
            Node * deleteNode =head->next;
            head->next = head->next->next;
            if(deleteNode == tail) tail = head;
            delete deleteNode;
        }
        else head = head->next;
    }
}
int main(){
    Node * head = NULL;
    Node * tail = NULL;

    while (true)
    {
        int a;
        cin>>a;
        if(a==-1) break;
        insert_tail(head,tail,a);
    }
    sort_list(head);
    unique_list(head,tail);
    while(head != NULL)
    {
        cout<<head->val<<" ";
        head = head->next;
    }
return 0;
}

// 2nd way-------------------------------
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


void print(Node * head)
{
    while(head != NULL)
    {
        cout<<head->val<<" ";
        head= head->next;
    }
    cout<<endl;
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
    Node *temp = head;
    while(temp != NULL)
    {
        int a = temp->val;
        Node * temp2 = temp;
        while(temp2->next != NULL)
        {
            if(temp2->next->val==a){
                Node * deleteNode = temp2->next;
                temp2->next= temp2->next->next;
                delete deleteNode;
                continue;
            }
            temp2 = temp2->next;
            if(temp2==NULL) break;
        }
        temp=temp->next;
    }
    // for(Node * i = head; i->next!=NULL; i=i->next)
    // {
    //     for(Node * j = i->next; j!=NULL; j=j->next)
    //     {
    //         if(i->val>j->val)
    //         {
    //             swap(i->val , j->val);
    //         }
    //     }
    // }
    print(head);
    
return 0;
}