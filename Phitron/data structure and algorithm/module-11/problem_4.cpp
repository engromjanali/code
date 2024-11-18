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
        if(cur == NULL || cur->next == NULL){
            head = cur;
            return;
        }
        reverse_link_list(head, cur->next);
        cur->next->next = cur;
        cur->next = NULL;
    
    }

    ListNode* reverseList(ListNode* head) {
        reverse_link_list(head,head);
        return head;
    }
};