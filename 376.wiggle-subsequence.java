/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {

        if(nums.length == 0) return 0;
        
       //greedy
       int up = 1, down = 1;
       for(int i = 1;i < nums.length; i++){
           if(nums[i] > nums[i-1]) up = down + 1;
           if(nums[i] < nums[i-1]) down = up + 1;
       }        
       return Math.max(up,down);
       //todo 更新 动态规划方法
    }
}

