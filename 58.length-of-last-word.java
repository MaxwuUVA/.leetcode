/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */
class Solution {
    public int lengthOfLastWord(String s) {
        //string
        String[] strs = s.split(" ");//split string
        if(s.length() == 0 || strs.length == 0) return 0;
        return strs[strs.length-1].length();
        
    }
}

