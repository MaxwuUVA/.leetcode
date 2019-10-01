/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {        
        //array
        //dp
        //O(n)优化
        if(triangle == null || triangle.size() == 0){
            return -1;
        }
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);//初始化
        
        for(int i = 1;i < triangle.size();i++){
             int rowsize = triangle.get(i).size();
             dp[rowsize-1] = dp[rowsize-2]+triangle.get(i).get(rowsize-1);   
             for(int j = rowsize-2;j >= 0;j--){
                 if(j > 0 && j < rowsize-1){
                     dp[j] = Math.min(dp[j-1],dp[j])+triangle.get(i).get(j);
                 }
                 if(j == 0){
                     dp[j] = dp[j]+triangle.get(i).get(j);
                 }
             }
        }
        int min = Integer.MAX_VALUE;
        for(int num:dp){
            min = Math.min(min,num);
        }
        return min;
    }
}

