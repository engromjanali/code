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
    void delete_position(ListNode *& head, ListNode * head2)
    {
        if(head2==NULL)
        {
            ListNode * deleteNode = head;
            head = head->next;
            delete deleteNode;
            return;
        }

        ListNode * temp = head;
        while(head2->next != NULL)
        {
            temp = temp->next;
            head2 = head2->next;
        }
        ListNode * deleteNode = temp->next;
        temp->next = temp->next->next;
        delete deleteNode;
    }
    ListNode* removeNthFromEnd(ListNode* head, int n) { 
         ListNode * head2 = head; 
         while(n--)
         {
            head2= head2->next;
         }
         delete_position(head,head2);
         return head;
    }
};