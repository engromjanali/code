#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
    
    int val;
    Node * next;// it's a pointer of this class. we can create an pointer of This class.
    
    Node(int val)
    { 
        this->val=val;
        this->next=NULL;
        
    }
};

int main(){

    Node * head = new Node(10);
    Node * a = new Node(20);

    head->next= a;// only a, because a is pointer who point a object.

    cout<<head->val<<endl;
    cout<<a->val<<endl;  //value of b.
    cout<<head->next->val<<endl; //value of b.
    cout<<(*(*head).next).val<<endl; //value of b.

return 0;
}