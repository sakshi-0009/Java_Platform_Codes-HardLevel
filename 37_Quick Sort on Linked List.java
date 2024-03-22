/* Problem Statement :-
You are given a Linked List. Sort the given Linked List using quicksort. 
*/

// Answer :-

class GfG {
    public static Node quickSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        
        Node pivot = partition(node);
        
        pivot.next = quickSort(pivot.next);
        
        return pivot;
    }
    
    private static Node partition(Node head) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        
        Node pivot = tail; // Choosing the last element as the pivot
        Node smallerHead = new Node(0); // Dummy node for the smaller sublist
        Node smallerTail = smallerHead;
        Node greaterHead = new Node(0); // Dummy node for the greater sublist
        Node greaterTail = greaterHead;
        
        Node curr = head;
        while (curr != pivot) {
            if (curr.data < pivot.data) {
                smallerTail.next = curr;
                smallerTail = smallerTail.next;
            } else {
                greaterTail.next = curr;
                greaterTail = greaterTail.next;
            }
            curr = curr.next;
        }
        
        smallerTail.next = pivot;
        pivot.next = greaterHead.next;
        greaterTail.next = null;
        
        return smallerHead.next;
    }
    
}
