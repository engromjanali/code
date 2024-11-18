// the V will be remove from hoal list.
    void delete_element(ListNode * & head, int V)
    {
        ListNode * temp = head;
        while(temp != NULL && temp->next != NULL)
        {
            ListNode * deleteNode = temp->next;
            if(temp->next->val == V)
            {
                temp->next = temp->next->next;
                delete deleteNode;
            }
            else temp = temp->next;
        }
        if(head != NULL && head->val==V)
        {
                head=head->next;
        } 
    }