#include <bits/stdc++.h> 
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
class Queue {
public:
    Queue() {
        // Implement the Constructor
    }

    /*----------------- Public Functions of Queue -----------------*/
    Node * head = NULL;
    Node * tail = NULL;
    int siz= 0;
    bool isEmpty() {
        return siz ==0;
    }

    void enqueue(int data) {
        siz ++;
        Node * newNode = new Node(data);
        if(head == NULL)
        {
            head = newNode;
            tail = newNode;
            return;
        }
        tail->next = newNode;
        tail = newNode;
    }

    int dequeue() {
        
        if(siz==0) return -1;
        siz--;
        int res = head->val; 
        if(head->next == NULL)
        {
            delete head;
            head = NULL;
            tail = NULL;
        }
        else{
            Node * deleteNode = head;
            head = head->next;
            delete deleteNode;
        }
        return res;
    }

    int front() {
        if(siz ==0) return -1;
        return head->val;
    }
};