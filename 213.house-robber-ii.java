/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */
class Solution {
    public int rob(int[] nums) {
        
        //array
        //dp
        //dp[i] = max(dp[i-2]+nums[i],dp[i-1]);
        //first last 取其中之一比较中间的最大值即可
        if( nums == null || 
            nums.length == 0){
            return 0;
        }
        if(nums.length < 2){
            return nums[0];
        }
        int[] first = Arrays.copyOfRange(nums,0,nums.length-1);
        int[] last = Arrays.copyOfRange(nums,1,nums.length);
        return dp(first) > dp(last) ? dp(first):dp(last);
    }
    private int dp(int[] nums){
        if(nums == null ||
           nums.length == 0){
            return 0;
        }
        if(nums.length < 2){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
     if(nums.length > 2){
        for(int i = 2;i < nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
    }
        return dp[nums.length-1];
    }
    
}

