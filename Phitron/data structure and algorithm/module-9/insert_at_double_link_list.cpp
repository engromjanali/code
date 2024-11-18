#include <bits/stdc++.h>
using namespace std;
class Node
{
public:
    int val;
    Node *next;
    Node *prev;
    Node(int val)
    {
        this->val = val;
        this->next = NULL;
        this->prev = NULL;
    }
};
void print_normal(Node *head)
{
    Node *tmp = head;
    while (tmp != NULL)
    {
        cout << tmp->val << " ";
        tmp = tmp->next;
    }
    cout << endl;
}
void print_reverse(Node *tail)
{
    Node *tmp = tail;
    while (tmp != NULL)
    {
        cout << tmp->val << " ";
        tmp = tmp->prev;
    }
    cout << endl;
}
void insert_at_position(Node *& head, Node *& tail, int pos, int val)
{
    Node *newNode = new Node(val);
    Node *tmp = head;
    // for head.
    if(head == NULL)
    {
        if(pos == 0)
        {
            head = new Node(val);
            tail = head;
        }
        return;
    }
    if(pos == 0)
    {
        newNode->next = head;
        head->prev = newNode;
        head = newNode;
        return;
    }
    
    //for tail.
    if(!head) return; // it's for if (head == NULL) but we want to trying to insert value in 1 or N position. it hendel.
    for (int i = 1; i < pos; i++)
    {
        if(tmp->next == NULL) return;// index out of bounds handeled.
        tmp = tmp->next;
    }
    newNode->next = tmp->next; 
    newNode->prev = tmp;          
    tmp->next = newNode;
    if(tmp->next->next==NULL) tail=newNode;
    else newNode->next->prev=newNode;      
}

int size(Node *head)
{
    Node *tmp = head;
    int cnt = 0;
    while (tmp != NULL)
    {
        cnt++;
        tmp = tmp->next;
    }
    return cnt;
}
void insert_head(Node *&head, Node *&tail, int val)
{
    Node *newNode = new Node(val);
    if (head == NULL)
    {
        head = newNode;
        tail = newNode;
        return;
    }
    newNode->next = head;
    head->prev = newNode;
    head = newNode;
}
void insert_tail(Node *&head, Node *&tail, int val)
{
    Node *newNode = new Node(val);
    if (tail == NULL)
    {
        head = newNode;
        tail = newNode;
        return;
    }
    tail->next = newNode;
    newNode->prev = tail;
    tail = tail->next;
}
int main()
{
    // Node * head = NULL;
    // Node * tail = NULL;
    Node *head = new Node(10);
    Node *a = new Node(20);
    Node *b = new Node(30);
    Node *c = new Node(40);
    Node *tail = c;

    // connection
    head->next = a;
    a->prev = head;  
    a->next = b;
    b->prev = a;
    b->next = c;
    c->prev = b;
    int pos, val;
    cin >> pos >> val;

    if (pos > size(head))
    {
        cout << "Invalid" << endl;
    }
    else
    {
        insert_at_position(head, tail, pos, val);
    }
    print_normal(head);
    print_reverse(tail);

    return 0;
}