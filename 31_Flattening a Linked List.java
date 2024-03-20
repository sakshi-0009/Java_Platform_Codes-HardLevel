/* Problem Statement :-
Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
*/

// Answer :-

class GfG {
    Node merge(Node a, Node b) {
        
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        return result;
    }

    // Function to flatten the linked list
    Node flatten(Node root) {
        if (root == null || root.next == null)
            return root;

        // Recursively flatten the next list
        root.next = flatten(root.next);

        // Merge the current list with the flattened next list
        root = merge(root, root.next);

        return root;
    }

    // Utility function to print the linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }
    
}
