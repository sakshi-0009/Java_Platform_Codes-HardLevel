/* Problem Statement :-
Given two decimal numbers represented by two linked lists of size N and M respectively. The task is to return a linked list that represents the sum of these two numbers.
For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null.
Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return the head of the linked list 2->1->5->null.
*/

// Answer :-

class Solution{
    static Node addTwoLists(Node first, Node second){
        Node dummyHead = new Node(0);
        Node current = dummyHead;
        int carry = 0;

        while (first != null || second != null || carry != 0) {
            int sum = carry;
            if (first != null) {
                sum += first.data;
                first = first.next;
            }
            if (second != null) {
                sum += second.data;
                second = second.next;
            }
            carry = sum / 10;
            current.next = new Node(sum % 10);
            current = current.next;
        }

        return dummyHead.next;
    }
}
