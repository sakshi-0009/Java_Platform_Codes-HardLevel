/* Problem Statement :-
You are given the head of a linked list.
Remove every node which has a node with a greater value anywhere to the right side of it.
Return the head of the modified linked list.
*/

// Answer :-

class Solution {

    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        ListNode prev = dummy;

        while (current != null) {
            ListNode nextNode = current.next;
            boolean remove = false;

            // Check if there exists a node with a greater value anywhere to the right
            while (nextNode != null) {
                if (nextNode.val > current.val) {
                    remove = true;
                    break;
                }
                nextNode = nextNode.next;
            }

            if (remove) {
                prev.next = current.next;
            } else {
                prev = current;
            }

            current = current.next;
        }

        return dummy.next;
    }
}
