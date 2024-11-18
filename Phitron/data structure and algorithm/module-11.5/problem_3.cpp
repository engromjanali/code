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
    ListNode* swapNodes(ListNode* head, int k) {
        ListNode * head1 = head;
        ListNode * head2 = head;

        int v1;
        int v2;

        for(int i =1; i<k; i++)
        {
            head2=head2->next;
        }
        v1 = head2->val;

        while(head2->next != NULL)
        {
            head2 = head2->next;
            head1 = head1->next;
        }
        v2 = head1->val;
        head1->val = v1;

        head1 = head;
        k--;
        while(k--)
        {
            head1 = head1->next;
        }
        head1->val = v2;
        return head;
    }
};