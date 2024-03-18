/* Problem Statement :- 
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
*/

// Answer :-

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Mark all negative numbers and numbers greater than n as they won't affect the result
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        
        // Mark the index of positive numbers as negative to indicate presence
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        
        // Find the first index which is positive, indicating the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        // If all indices are negative, return n + 1
        return n + 1;
    }
}
