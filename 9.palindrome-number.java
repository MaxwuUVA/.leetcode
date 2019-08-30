/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */
class Solution {
    public boolean isPalindrome(int x) {

        //利用string的性质来去除正负号的影响
        
        String s = String.valueOf(x);
        
        StringBuilder sb = new StringBuilder();
        
        char[] c = s.toCharArray();
        
        for(int i = c.length-1;i >= 0;i--){
            
               sb.append(c[i]);
            
        }
        
        String cvt = sb.toString();
        
        return cvt.equals(s);
        
    }
}

