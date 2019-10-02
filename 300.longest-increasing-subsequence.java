import java.util.Arrays;

/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
            if(nums.length == 0) return 0;
            //LIS问题
            //O(n^2)
            int len = nums.length,max = 1;
            int[] dp = new int[nums.length];
            Arrays.fill(dp,1);
            for(int i = 0;i < len;i++){
                for(int j = 0;j < i;j++){
                    if(nums[i] > nums[j] && dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                    }
                }
    
                max = Math.max(max,dp[i]);
                
            }
            
            return max;
            
    }
}

