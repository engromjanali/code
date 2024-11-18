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
class Stack
{
    //Write your code here

public:
    Stack()
    {
        //Write your code here
    }
    int siz=0;
    Node * head = NULL;
    Node * tail = NULL;
    int getSize()
    {
        return siz;
    }

    bool isEmpty()
    {
        return (siz==0);
    }

    void push(int val)
    {
        siz++;
        Node * newNode = new Node(val);
        if(tail == NULL)
        {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode->next = head;
        head = newNode;
    }

    void pop()
    {
        if(siz ==0) return;
        siz--;
        if(head->next == NULL)
        {
            Node * deleteNode = head;
            head = NULL;
            tail = NULL;
            delete deleteNode; 
            return;
        }
        Node * deleteNode = head;
        head = head ->next;
        delete  deleteNode;
    }

    int getTop()
    {
        if(siz ==0) return -1;
        return head->val;
    }
};