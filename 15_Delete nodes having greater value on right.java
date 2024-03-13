/* problem Statement :-
Given a singly linked list, remove all the nodes in the list which have any node on their right whose value is greater. (Not just immediate Right , but entire List on the Right)
*/

// Answer :-

class Solution {
    public Node compute(Node head) {
        if (head == null || head.next == null)
            return head;

        Node current = head;

        while (current != null && current.next != null) {
            if (current.data < current.next.data) {
                current.data = current.next.data;
                current.next = current.next.next;
                continue;
            }
            current = current.next;
        }

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
