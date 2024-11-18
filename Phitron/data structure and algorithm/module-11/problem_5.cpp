/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
// delete a node. but you will be geban current node. so we have to delete next node after we have to hold the next value in current node.
// https://leetcode.com/problems/delete-node-in-a-linked-list/
class Solution {
public:
    void deleteNode(ListNode* node) {
        ListNode* deleteNode = node->next;
        node->val = node->next->val;
        node->next = node->next->next;
        delete deleteNode;
    }
};