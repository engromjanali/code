class Node {
public:
    int val;
    Node * next;
    Node * prev;
    Node(int v) {
        val = v;
        next = NULL;
        prev = NULL;
    }
};
class MyLinkedList {
public :    
    Node * head = NULL;
    Node * tail = NULL;

    MyLinkedList(){
        head = NULL;
        tail = NULL;
    }

    int get(int index) {
        Node * temp = head;
        while(index --)
        {
            if(temp == NULL) return -1;
            temp = temp->next;
        }
        if(temp == NULL) return -1;
        return temp->val;
    }
    
    void addAtHead(int val) {
        if(head == NULL){
            head = new Node(val);
            tail = head;
            return;
        } 
        Node * newNode = new Node(val);
        head->prev = newNode;
        newNode->next = head;
        head = newNode;

    }
    
    void addAtTail(int val) {
        if(head == NULL)
        {
            head = new Node(val);
            tail = head;
            return;
        }
        Node * newNode = new Node(val);
        tail->next = newNode;
        newNode->prev = tail;
        tail = tail->next;
        
    }
    
    void addAtIndex(int pos, int val) {
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
    
    void deleteAtIndex(int P) {
        if(head==tail )
        {
            if(P==0)
            {
                delete head;
                head = NULL;
                tail = NULL;
                return;
            }
            return;
        }
        if(P==0)
        {
            Node * deleteNode = head;
            head=head->next;
            head->prev=NULL;
            delete deleteNode;
            return;
        }
        Node * temp = head;
        for(int i=1; i<P; i++)
        {
            if(temp->next->next ==NULL) return;
            temp = temp->next;
        }
        Node * deleteNode = temp->next;
        temp->next=temp->next->next;
        if(temp->next==NULL) tail = temp;
        else temp->next->prev=temp;
        delete deleteNode;
    }
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */