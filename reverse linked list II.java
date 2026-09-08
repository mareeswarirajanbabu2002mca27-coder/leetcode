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
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to ease edge cases (like reversing from the first node)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Step 1: Move 'prev' to the node right before the sublist starts
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // Step 2: 'curr' will be the first node of the sublist to be reversed
        ListNode curr = prev.next;

        // Step 3: Reverse the sublist link by link
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = curr.next;
            
            // Cut out nextNode and stitch curr to the node after nextNode
            curr.next = nextNode.next;
            
            // Move nextNode to the front of the reversed sublist section
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummy.next;
    }
}
