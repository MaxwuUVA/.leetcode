/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */
class Solution {
    public int maxProfit(int k,int[] prices) {

        if(prices.length == 0) return 0;

        //array
        //系列中最复杂的一道题
        //设定两个dp数组
        //第一个代表第i天交易j次得到的最大值
        //第二个代表全局在第i天交易j次得到的最大值
        //递推公式
        // diff = prices[i] - prices[i-1]
        //local[i][j] = max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)
        //global[i][j] = max(local[i][j],global[i-1][j])
        //用通用公式MLE，所以k > prices.length时退化为贪心算法

        if( k >= prices.length){
               return maxprofitgreedy(prices);
        }
        int n = prices.length;
        int[][] global = new int[n][k+1];
        int[][] local = new int[n][k+1];
        for(int i = 1;i < n;i++){
            int diff = prices[i] - prices[i-1];
            for(int j = 1; j <= k;j++){
                local[i][j] = Math.max(global[i-1][j-1]+Math.max(diff, 0), local[i-1][j]+diff);
                global[i][j] = Math.max(local[i][j], global[i-1][j]);
            }

        }

        return global[n-1][k];

        
    }
    private int maxprofitgreedy(int[] prices){
        int maxprofit = 0,tmp = prices[0];
        for(int i = 1;i < prices.length;i++){
            if(prices[i] - tmp < 0){
                tmp = prices[i];
            }
            else{
                maxprofit += prices[i] - tmp;
                tmp = prices[i];
            }
        }
        return maxprofit;
    }
}


