/* Problem Statement :-
Given the head of a linked list, remove the nth node from the end of the list and return its head.
*/

// Answer :-

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move the second pointer n steps ahead
        for (int i = 0; i <= n; i++) {
            second = second.next;
        }

        // Move both pointers simultaneously until the second pointer reaches the end
        while (second != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from the end
        first.next = first.next.next;

        return dummy.next;
    }
}
