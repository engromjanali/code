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
void insert_in_tail(Node *& head, int V)
{
    Node * temp = head;
    Node * newNode = new Node(V);
    if(temp==NULL)
    {
        head= newNode;
        return;
    }
    while(temp->next!=NULL)
    {
        temp= temp->next;
    }
    temp->next=newNode;
}

void print_position_element(Node * head, int P)
{
    while(P--) //by while loop
    {
        head=head->next;
    }
    // for(int i=0; i<P; i++)  // by for loop
    // {
    //     head=head->next;
    // }
    cout<<head->val<<" ";
}
int main(){

    Node * head= NULL;
    while(true)
    {
        int V;
        cin>>V;
        if(V==-1)
        {
            break;
        }
        insert_in_tail(head, V);
    }
    cout<<"print n index element : ";
    int N;
    cin>>N;
    print_position_element(head,N);

return 0;
}