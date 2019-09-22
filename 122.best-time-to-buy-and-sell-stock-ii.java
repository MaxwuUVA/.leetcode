/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */
class Solution {
    public int maxProfit(int[] prices) {
        
        //greedy
        //证明假如存在一个n，m
        //1,n,m升序，且m-1大于分别greedy方式 m-n+n-1=m-1 和greedy方式相等
        //所以不存在这样的方式
        if(prices.length == 0) return 0;
        int profit = 0,tmp = prices[0];
        for(int i = 1;i < prices.length;i++){
            if(tmp > prices[i]){
                tmp = prices[i];
            }
            else{
                profit += prices[i] - tmp;
                tmp = prices[i];
            }

        }

        return profit;
        
    }
}

