/*
 * @lc app=leetcode id=172 lang=java
 *
 * [172] Factorial Trailing Zeroes
 */
class Solution {
    public int trailingZeroes(int n) {
        
        //Math
        //trick
        //计算所有数字中10的个数
        //10 = 2*5
        //因为阶乘数中2比5多的多所以计算5的个数
        int res = 0;
        while(n > 0){
            res += n/5;
            n /= 5;
        }
        
        return res;
        
    }
}

