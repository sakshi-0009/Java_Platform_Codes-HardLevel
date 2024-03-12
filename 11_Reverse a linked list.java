/* Problem Statement :-
Given a linked list of N nodes. The task is to reverse this list.
*/ 

// Answer :-

class Solution {
    Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node nextNode;
        
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        
        return prev;
    }
}
