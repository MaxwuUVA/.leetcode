/*
 * @lc app=leetcode id=334 lang=java
 *
 * [334] Increasing Triplet Subsequence
 */
class Solution {
    public boolean increasingTriplet(int[] nums) {
         //array
         //想法是找到两个指针small，big，small < big
         //如果存在一个数大于这两个指针，则存在这样的子序列
         //否则没有
         int nums1 = Integer.MAX_VALUE;
         int nums2 = Integer.MAX_VALUE;
         for(int n:nums){
             if(nums1 >= n) nums1 = n;//
             else if(nums2 >= n) nums2 = n;//
             else return true;
         }
        return false;
    }
}

