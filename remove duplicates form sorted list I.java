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
        // Base case: if the list is empty or has only one element, no duplicates exist
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = head;
        
        while (curr != null && curr.next != null) {
            // If the current node value matches the next node value, skip the next node
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                // Otherwise, move to the next unique node
                curr = curr.next;
            }
        }
        
        return head;
    }
}
