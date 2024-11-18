/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void reverse_link_list(ListNode *& head, ListNode * cur)
    {
        if( cur ==  NULL || cur->next == NULL)
        {
            head = cur;
            return;
        }
        reverse_link_list(head, cur->next);
        cur->next->next = cur;
        cur->next = NULL;
    }
    void insert_tail(ListNode *& head, ListNode *& tail, int V)
    {
        ListNode * newNode = new ListNode(V);
        if(head == NULL){
            head = newNode;
            tail = newNode;
            return;
        }
        tail->next = newNode;
        tail = newNode;
    }
    void copy_link_list(ListNode * head1, ListNode *& head2, ListNode *& tail2){
        while(head1 != NULL)
        {
            insert_tail(head2,tail2,head1->val);
            head1 = head1->next;
        }
    }

    bool isPalindrome(ListNode* head) {
        ListNode * head2 = NULL;
        ListNode * tail2 = NULL;
        copy_link_list(head,head2,tail2);
        reverse_link_list(head2,head2);
        while(head != NULL)
        {
            if(head->val != head2->val) return false;
            head = head->next;
            head2 = head2->next;
        }
        return true;
    }
};