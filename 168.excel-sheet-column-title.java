/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 */
class Solution {
    public String convertToTitle(int n) {
         
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append((char)('A'+(n-1)%26));
            n = (n-1)/26;//corner case n-1
        }
        return sb.reverse().toString();
        
    }
}

