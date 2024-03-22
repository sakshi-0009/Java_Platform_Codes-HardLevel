/* Problem Statement :-
You are given a special linked list with N nodes where each node has a next pointer pointing to its next node.
You are also given M random pointers, where you will be given M number of pairs denoting two nodes a and b  i.e. a->arb = b (arb is pointer to random node).

Construct a copy of the given list. The copy should consist of exactly N new nodes, where each new node has its value set to the value of its corresponding original node.
Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.arb --> Y, then for the corresponding two nodes x and y in the copied list, x.arb --> y.

Return the head of the copied linked list.
*/

// Answer :-

class Clone {
    Node copyList(Node head) {
        if (head == null)
            return null;

        // Step 1: Create a copy of each node and insert it between original node and its next node
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.data);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Set the random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.arb != null)
                curr.next.arb = curr.arb.next;
            curr = curr.next.next;
        }

        // Step 3: Separate the original list from the copied list
        Node originalHead = head;
        Node copiedHead = head.next;
        Node originalCurr = originalHead;
        Node copiedCurr = copiedHead;

        while (originalCurr != null) {
            originalCurr.next = originalCurr.next.next;
            copiedCurr.next = (copiedCurr.next != null) ? copiedCurr.next.next : null;
            originalCurr = originalCurr.next;
            copiedCurr = copiedCurr.next;
        }

        // Step 4: Return the head of the copied list
        return copiedHead;
        
    }
}
