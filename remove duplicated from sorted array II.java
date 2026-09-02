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
    public ListNode deleteDuplicates(ListNode head) {
        // Use a dummy node to easily handle head deletions
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy; // Tracks the last confirmed distinct node
        ListNode curr = head;  // Used to scan the list
        
        while (curr != null) {
            // Check if the current node has a duplicate neighbor
            if (curr.next != null && curr.val == curr.next.val) {
                // Move curr forward to find the end of the duplicate sequence
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                // Skip all nodes in the duplicate sequence
                prev.next = curr.next;
            } else {
                // No duplicate detected, safe to advance the prev pointer
                prev = prev.next;
            }
            // Move curr to the next potential distinct node
            curr = curr.next;
        }
        
        return dummy.next;
    }
}
