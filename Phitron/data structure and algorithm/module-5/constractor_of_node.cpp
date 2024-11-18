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

    Node a(10);
    Node b(20);

    a.next= &b;
    b.next=NULL;

    cout<<a.val<<endl;
    cout<<b.val<<endl;  //value of b.
    cout<<(*a.next).val<<endl; //value of b.
    cout<<a.next->val<<endl; //value of b.

return 0;
}
