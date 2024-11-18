// https://leetcode.com/problems/remove-linked-list-elements/

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
    ListNode* removeElements(ListNode* head, int val) {
        delete_element(head,val);
        return head;
    }
};