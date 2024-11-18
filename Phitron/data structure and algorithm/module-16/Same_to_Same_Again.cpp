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
class mystack{
public :
    Node * head = NULL;
    Node * tail = NULL;
    int sz = 0;
    int size()
    {
        return sz;
    }
    bool empty()
    {
        return (sz == 0);
    }
    int top()
    {
        return tail->val;
    }
    void push(int x)
    {
        sz++;
        Node * newNode = new Node(x);
        if(head == NULL)
        {
            head = newNode;
            tail = newNode;
            return;
        }
        tail->next = newNode;
        newNode->prev = tail;
        tail = newNode;
    }
    void pop()
    {
        sz--;
        if(head->next == NULL)
        {
            delete head;
            head = NULL;
            tail = NULL;
            return;
        }
        Node * deleteNode = tail;
        tail = tail->prev;
        delete deleteNode;
    }
};

class myqueue{
public :
    Node * head = NULL;
    Node * tail = NULL;
    int sz = 0;
    int size()
    {
        return sz;
    }
    bool empty()
    {
        return (sz == 0);
    }
    int front()
    {
        return head->val;
    }
    void push(int x)
    {
        sz++;
        Node * newNode = new Node(x);
        if(head == NULL)
        {
            head = newNode;
            tail = newNode;
            return;
        }
        tail->next = newNode;
        newNode->prev = tail;
        tail = newNode;
    }
    void pop()
    {
        sz--;
        if(head->next == NULL)
        {
            delete head;
            head = NULL;
            tail = NULL;
            return;
        }
        Node * deleteNode = head;
        head = head->next;
        delete deleteNode;
    }
};
int main(){

    int a , b;
    cin>>a>>b;
    mystack st;
    myqueue qu;
    while(a--){
        int x;
        cin>>x;
        st.push(x);
    }

    while(b--){
        int x;
        cin>>x;
        qu.push(x);
    }
    
    if(st.size() != qu.size()) cout<<"NO"<<endl;
    else
    {
        bool flag = true;
        while(!qu.empty())
        {
            // cout<<st.top()<<qu.front()<<endl;
            if(st.top() != qu.front()) 
            {
                cout<<"NO"<<endl;
                flag = false;
                break;
            }
            st.pop();
            qu.pop();
        }
        if(flag) cout<<"YES"<<endl;
    }

return 0;
}