/* Problem Statement :-
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
*/

// Answer :-

class Solution {
    public void flatten(TreeNode root) {
        if (root==null) return;
        
        dfs(root);
    }
    
    private TreeNode dfs(TreeNode root) {
        if (root==null) return root;
        
        TreeNode leftTail = dfs(root.left);
        TreeNode rightTail = dfs(root.right);
        
        if (leftTail!=null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if (rightTail!=null) return rightTail;
        else if (leftTail!=null) return leftTail;
        else return root;
    }
}
