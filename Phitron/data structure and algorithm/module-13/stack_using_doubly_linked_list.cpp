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
class myStack
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
            // Node * deleteNode = tail;
            // if(head->next == NULL)
            // {
            //     head = NULL;
            //     tail = NULL;
            //     delete deleteNode;
            //     return;
            // }
            // tail = tail->prev;
            // tail->next = NULL;
            // delete deleteNode;

            //2nd way 

            if(head==tail)// it's valid with hendel error(null pointer)
            {
                delete head;
                head = NULL;
                tail = NULL;
                return;
            }
            Node * deleteNode = tail;
            tail=tail->prev;
            tail->next=NULL;
            delete deleteNode;
        }
        int top()
        {
            return tail->val;
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
    myStack mystack;
    int a;
    cin>>a;
    while(a--)
    {
        int x;
        cin>>x;
        mystack.push(x);
    }
    while(!mystack.empty())
    {
        cout<<mystack.top()<<endl;
        mystack.pop();
    }
    
    if(!mystack.empty())
    {
        mystack.pop();
        cout<<"hii";
    }
return 0;
}