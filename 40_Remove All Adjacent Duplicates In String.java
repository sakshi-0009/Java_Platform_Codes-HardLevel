/* problem Statement :-
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
*/

// Answer :-

class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
    
        for (char c : s.toCharArray()) {
            int length = stack.length();
            if (length > 0 && stack.charAt(length - 1) == c) {
                stack.deleteCharAt(length - 1);
            } else {
                stack.append(c);
            }
        }
        
        return stack.toString();
    }
}
