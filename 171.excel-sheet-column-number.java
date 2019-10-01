/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */
class Solution {
    public int titleToNumber(String s) {

        int len = s.length(),res = 0;
        if(len == 0) return 0;
        for(int i = len-1;i >= 0;i--){
           int n = s.charAt(i) - 'A'+1;//加1符合字典‘a’=1；
           res += n*(int)Math.pow(26,(len-1)-i);
        }
        return res;
    }
}

