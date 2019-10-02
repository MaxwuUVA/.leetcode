/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */
class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length == 0) return 0;

        //array
        //dp
        //理解
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        for(int i = 1;i < prices.length;i++){
            buy[i] = Math.max((i>2?sell[i-2]:0)-prices[i],buy[i-1]);
            sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]);
        }
        return sell[prices.length-1];
    }
}

