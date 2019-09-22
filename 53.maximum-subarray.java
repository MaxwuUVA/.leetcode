/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */
class Solution {
    public int maxSubArray(int[] A) {

        //array
        //dp
        
        int n = A.length;
        int[] dp = new int[n+1];
        int max = A[0];
        
        for(int i = 1; i < n+1; i++){
            dp[i] = dp[i-1] > 0 ? dp[i-1]+A[i-1]:A[i-1];
            max = Math.max(max, dp[i]);
        }
        
        return max;
   }
}

