/* problem Statement :-
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
*/

// Answer :-

class Solution {
    public boolean isPalindrome(ListNode head) {
         ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null;
        while(slow!=null){
            ListNode current=slow;
            slow=slow.next;
            current.next=prev;
            prev=current;
        }
        ListNode start=head;
        while(start!=null&&prev!=null){
            if (start.val!=prev.val){
                return false;
            }
            start=start.next;
            prev=prev.next;
        }
        return true;
    }
}
