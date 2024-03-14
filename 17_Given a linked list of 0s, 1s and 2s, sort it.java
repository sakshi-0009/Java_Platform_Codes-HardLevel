/* problem Statement :-
Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only.
The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.
*/

// Answer:-

class Solution {
    static Node segregate(Node head) {
        if (head == null || head.next == null)
            return head;

        Node zeroHead = new Node(0);
        Node oneHead = new Node(0);
        Node twoHead = new Node(0);

        Node zeroTail = zeroHead;
        Node oneTail = oneHead;
        Node twoTail = twoHead;

        Node current = head;

        while (current != null) {
            if (current.data == 0) {
                zeroTail.next = current;
                zeroTail = zeroTail.next;
            } else if (current.data == 1) {
                oneTail.next = current;
                oneTail = oneTail.next;
            } else {
                twoTail.next = current;
                twoTail = twoTail.next;
            }
            current = current.next;
        }

        zeroTail.next = oneHead.next != null ? oneHead.next : twoHead.next;
        oneTail.next = twoHead.next;

        twoTail.next = null;

        head = zeroHead.next;

        return head;
    }

    // Function to print the linked list
    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
