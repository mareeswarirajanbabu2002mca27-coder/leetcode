/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        
        // Find the k-th node
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        
        // If we have k nodes, reverse them
        if (count == k) {
            // Reverse k nodes and get the new head of this reversed segment
            curr = reverseKGroup(curr, k); // curr now points to the head of the next group
            
            // Standard linked list reversal for the current group
            while (count-- > 0) {
                ListNode nextNode = head.next;
                head.next = curr;
                curr = head;
                head = nextNode;
            }
            head = curr;
        }
        return head;
    }
}
