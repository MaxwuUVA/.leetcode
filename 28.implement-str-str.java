/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int l = haystack.length();
        int r = needle.length();
        //substring[l..,r)
        int i = 0;
        while(i < l - r + 1){
            if(haystack.substring(i, i+r).equals(needle)){
                return i;
            }
            i++;
        }
        return -1;
    }
}

