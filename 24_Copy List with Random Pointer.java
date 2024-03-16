/* Problem Statement :-
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state.
None of the pointers in the new list should point to nodes in the original list.
For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.
*/

// Answer :-

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Map to store the mapping from original nodes to copied nodes
        HashMap<Node, Node> map = new HashMap<>();

        // First pass: create new nodes without random pointers and populate the map
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Second pass: set next and random pointers for copied nodes
        current = head;
        while (current != null) {
            Node copiedNode = map.get(current);
            copiedNode.next = map.get(current.next);
            copiedNode.random = map.get(current.random);
            current = current.next;
        }

        // Return the head of the copied list
        return map.get(head);
    }

    // Utility function to print the linked list
    public void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.val + "," +
                    (current.random != null ? current.random.val : "null") + "] -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
