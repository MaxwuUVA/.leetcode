/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */
class Solution {
    /*public int divide(int dividend, int divisor) {
        // bit manipulate
        if(divisor == 0 ||(divisor == -1 && dividend == Integer.MIN_VALUE)) return Integer.MAX_VALUE;

        if(divisor == 1) return dividend;

        int m = Math.abs(dividend);
        int n = Math.abs(divisor);
        int res = 0;
        int sign = ((dividend > 0) == (divisor > 0)) ? 1:-1;
        while(m >= n){
            int p = n,t = 1;
            while(m >=(p<<1)){
                p <<=1;
                t <<=1;

            }
            res += t;
            m -= p;

        }
        return sign == -1 ? -res:res;
    }*/
    public int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }
}

