/* Problem Statement :-
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
*/

// Answer :-

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans=0;
        int n1=nums1.length;
        int n2=nums2.length;
        int n3=n1+n2;
        int[] nums3=new int[n3];
        int k=0;
        for(int i=0;i<nums1.length;i++){
            nums3[k++]=nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            nums3[k++]=nums2[i];
        }
        Arrays.sort(nums3);
        if(n3%2==1){
            ans=(double)nums3[n3/2];
        }
        else{
            double m1=(double)nums3[n3/2];
            double m2=(double)nums3[(n3/2)-1];
            ans=(m1+m2)/2.0;
        }
        return ans;
    }
}
