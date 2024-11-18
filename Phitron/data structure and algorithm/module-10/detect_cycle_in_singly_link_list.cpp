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

bool detect_cycle(Node * head)
{
    bool flag = false;
    
    Node * slow = head;
    Node * fast = head;
    while(fast != NULL && fast->next != NULL)
    {
        slow = slow->next;
        fast = fast->next->next;
        if(slow==fast)
        {
            flag = true;
            return flag;
        }
    }
    return flag;
}

void insert_at_tail(Node *&head, Node *&tail, int v)
{
    Node *newNode = new Node(v);
    if (head == NULL) 
    {
        head = newNode;
        tail = newNode;
        return;
    }
    tail->next = newNode;
    tail = newNode;
}

int main(){
    Node * head = NULL;
    Node * tail = NULL;

    int N;
    cin>>N;
    while(N--)
    {
        int V;
        cin>>V;
        insert_at_tail(head,tail,V);
    }
    tail->next=head; // make cycled.
    if(detect_cycle(head))
    {
        cout<<"detected"<<endl;
    }
    else{
        cout<<"all is okk"<<endl;
    }

return 0;
}