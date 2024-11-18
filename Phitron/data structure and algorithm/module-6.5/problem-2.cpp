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

void insert_in_tail(Node*& head, int val){
    Node * newNode = new Node(val);
    Node*temp= head;
    if(temp==NULL)
    {
        head=newNode;
        return;
    }
    while(temp->next!=NULL)
    {
        temp= temp->next;
    }
    temp->next=newNode;
}
void count_value(Node * head, int count[])
{
    if(head==NULL)
    {
        return;
    }
    Node * temp=head;
    while(temp!=NULL)
    {
        count[temp->val-1]++;
        temp=temp->next;
    }
}

int main(){

    int count[100]={0};
    Node * head=NULL;
    while(true){
        int V;
        cin>>V;
        if(V==-1)
        {
            break;
        }
        insert_in_tail(head,V);
    }
    count_value(head, count);
    bool flag= false;
    for(int i=0; i<100; i++){
        if(count[i]>1){
            flag=true;
            break;
        }
    }
    if(flag){
        cout<<"YES";
    }
    else cout<<"NO";
return 0;
}