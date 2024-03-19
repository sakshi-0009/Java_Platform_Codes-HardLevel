/* Problem Statement :-
Given the head of a linked list, rotate the list to the right by k places.
*/

// Answer :-

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) 
            return head;

        ListNode cur = head;
        ListNode prev = null;
        int size = 0;
        while(cur != null) {
            prev = cur;
            cur = cur.next;
            size++;
        }
        cur = head;
        prev.next = cur;

        int rotate = k%size; //nodes to rotate from end
        int pos = size - rotate;// pos to skip nodes till rotated node

        for(int i = 0; i < pos; i++) {
            prev = cur;
            cur = cur.next;
        }

        prev.next = null;

        return cur;
    }
}
