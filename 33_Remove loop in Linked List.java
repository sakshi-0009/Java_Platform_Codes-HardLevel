/* Problem Statement :-
Given a linked list of N nodes such that it may contain a loop.
A loop here means that the last node of the link list is connected to the node at position X(1-based index). If the link list does not have any loop, X=0.
Remove the loop from the linked list, if it is present, i.e. unlink the last node which is forming the loop.
*/

// Answer :-

class Solution {
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        if (head == null || head.next == null)
            return;

        Node slow = head;
        Node fast = head;

        // Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        // If loop is found, find the start of the loop
        if (slow == fast) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            // Unlink the last node to remove the loop
            fast.next = null;
        }
    }

    // Function to print the linked list
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
