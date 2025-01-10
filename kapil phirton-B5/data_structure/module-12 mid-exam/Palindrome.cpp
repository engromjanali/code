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
int main(){
    Node * head = NULL;
    Node * tail = NULL;
    while (true)
    {
        int n;
        cin>>n;
        if(n==-1) break;
        insert_tail(head,tail,n);
    }
    bool flag = true;
    Node * temp1 =head;
    Node * temp2 =tail;
    while(temp1)
    {
        if(temp1->val!=temp2->val){
            flag = false;
            break;
        }
        temp1= temp1->next;
        temp2 = temp2->prev;
    }
    if(flag) cout<<"YES"<<endl;
    else cout<<"NO"<<endl;

return 0;
}