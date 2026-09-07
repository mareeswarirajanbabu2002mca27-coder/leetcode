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
    public ListNode partition(ListNode head, int x) {
        // Dummy nodes to hold the roots of the two queues
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        
        // Pointers used to append new elements to the two chains
        ListNode before = beforeHead;
        ListNode after = afterHead;
        
        // Traverse the original linked list
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        
        // Terminate the 'after' list to avoid cycles in the linked list
        after.next = null;
        
        // Connect the 'before' list with the 'after' list
        before.next = afterHead.next;
        
        return beforeHead.next;
    }
}
