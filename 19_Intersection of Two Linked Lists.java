/* Problem Statement :-
Given two linked lists of length n and m, the task is to complete the function findIntersection(), which returns the intersection of two linked lists.
Each of the two linked lists contains distinct node values.
*/

// Answer :-

class Solution {
    public static Node findIntersection(Node head1, Node head2) {
        Node intersection = null;
        Node tail = null;

        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                if (intersection == null) {
                    intersection = new Node(head1.data);
                    tail = intersection;
                } else {
                    tail.next = new Node(head1.data);
                    tail = tail.next;
                }
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data < head2.data) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }

        return intersection;
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
