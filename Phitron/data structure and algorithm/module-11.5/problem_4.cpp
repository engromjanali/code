
// https://leetcode.com/problems/merge-nodes-in-between-zeros/
// margeing  0 5 256 8 2 30 1 0 2 5 3 0 2 65 2 0
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
    ListNode* mergeNodes(ListNode* head) {
        ListNode * temp = head;
        while(temp != NULL && temp->next != NULL)
        {
            ListNode * deleteNode = temp->next;
            temp->val += temp->next->val;
            temp->next =temp->next->next;
            delete deleteNode;
            if(temp->next->val == 0) temp=temp->next;
        }
        delete_element(head,0);
        return head;
    }
};