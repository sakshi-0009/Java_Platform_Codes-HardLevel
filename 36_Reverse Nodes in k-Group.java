/* Problem Statement :-
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
*/

// Aswer :-

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        
        // Count the number of nodes in the current group
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        
        // If the current group has less than k nodes, return head as it is
        if (count < k) {
            return head;
        }
        
        // Reverse the current group
        ListNode prev = null;
        ListNode next = null;
        curr = head;
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Recursively reverse the next group and connect it with the current group
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        
        // Return the new head of the reversed group
        return prev;
    }
}
