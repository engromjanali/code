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

    int n; cin>>n;
    int m; cin>>m;
    
    myStack * stk = new myStack();
    myQueue * q = new myQueue();
    for(int i =0; i<n; i++){
        int a ; cin>>a;
        stk->push(a);
    }
    
    for(int i =0; i<m; i++){
        int a ; cin>>a;
        q->push(a);
    }
    bool flag = true;
    if(q->size()==stk->size())
    {
        while (!q->empty())
        {
            if(q->front() == stk->top()){
                q->pop();
                stk->pop();
                continue;
            }
            flag = false;
            break;
        }
        
    }
    else flag = false;
    
    if(flag) cout<<"YES"<<endl;
    else cout<<"NO"<<endl;

return 0;
}