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
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to point to the new head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        // Ensure there are at least two nodes to swap
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swapping logic
            first.next = second.next; // 1 -> 3
            second.next = first;      // 2 -> 1
            prev.next = second;       // dummy -> 2

            // Move the 'prev' pointer two nodes forward for the next pair
            prev = first;
        }

        return dummy.next;
    }
}
