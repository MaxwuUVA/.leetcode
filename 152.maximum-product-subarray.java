/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */
class Solution {
    public int maxProduct(int[] nums) {

        //array
        //dp
        //min[]存以i结尾的最小的product
        //max[]存以i结尾的最大的product
        //
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];
        int res = nums[0];
        for(int i = 1;i < nums.length;i++){
            
            int campmin = nums[i]*max[i-1] <= nums[i]*min[i-1]? nums[i]*max[i-1]:nums[i]*min[i-1];
            int campmax = nums[i]*max[i-1] >= nums[i]*min[i-1]? nums[i]*max[i-1]:nums[i]*min[i-1];
            min[i] = Math.min(nums[i],campmin);
            max[i] = Math.max(nums[i],campmax);
            res = Math.max(res,max[i]);
        }
        return res;
        
    }
}

