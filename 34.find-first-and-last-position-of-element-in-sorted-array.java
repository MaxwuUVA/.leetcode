/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {

        //二分查找的ceiling和floor
        //假如说ceiling和floor都不等于target return {-1,-1};


        int[] res = new int[2];
        Arrays.fill(res,-1);
        if(nums.length == 0) return res;
        int left = 0, right = nums.length;
        //find floor [left == target,....)

        while(left < right){
            int mid = left+(right-left)/2;
            if(nums[mid] < target) left = mid+1;
            else right = mid;
        }
        if(right == nums.length||nums[right] != target){
            return res;
        }
        res[0] = left;
        left = 0;
        right = nums.length;
        //find ceil(....target),left
        while(left < right){
            int mid = left+(right-left)/2;
            if(nums[mid] <= target) left = mid+1;
            else right = mid;
         }
        res[1] = right-1;
        return res; 
    }
}

