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
class myQueue
{
    public :
        Node * head = NULL;
        Node * tail = NULL;

        int sz =0;

        void push(int val)
        {
            sz++;
            Node * newNode = new Node(val);
            if(head == NULL)
            {
                head = newNode;
                tail = newNode;
                return;
            }
            tail->next = newNode;
            newNode->prev = tail;
            tail = tail ->next;
        }
        void pop()
        {
            sz--;

            if(head==tail)// it's valid with hendel error(null pointer)
            {
                delete head;
                head = NULL;
                tail = NULL;
                return;
            }
            Node * deleteNode = head;
            head=head->next;
            head->prev=NULL;
            delete deleteNode;
        }
        int front()
        {
            return head->val;
        }
        bool empty()
        {
            return head==NULL;
        }
        int size()
        {
            return sz;
        }
};
int main(){
    myQueue qu;
    int a;
    cin>>a;
    while(a--)
    {
        int x;
        cin>>x;
        qu.push(x);
    }
    while(!qu.empty())
    {
        cout<<qu.front()<<endl;
        qu.pop();
    }
    
    if(!qu.empty())
    {
        qu.pop();
        cout<<"hii";
    }
return 0;
}