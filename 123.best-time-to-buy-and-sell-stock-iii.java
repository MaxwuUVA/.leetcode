/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */
class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length == 0) return 0;

        //array
        //系列中最复杂的一道题
        //设定两个dp数组
        //第一个代表第i天交易j次得到的最大值
        //第二个代表全局在第i天交易j次得到的最大值
        int n = prices.length;
        int[][] global = new int[n][3];
        int[][] local = new int[n][3];
        //递推公式
        // diff = prices[i] - prices[i-1]
        //local[i][j] = max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)
        //global[i][j] = max(local[i][j],global[i-1][j])

        for(int i = 1;i < n;i++){
            int diff = prices[i] - prices[i-1];
            for(int j = 1; j <= 2;j++){
                local[i][j] = Math.max(global[i-1][j-1]+Math.max(diff, 0), local[i-1][j]+diff);
                global[i][j] = Math.max(local[i][j], global[i-1][j]);
            }

        }

        return global[n-1][2];

        
    }
}

