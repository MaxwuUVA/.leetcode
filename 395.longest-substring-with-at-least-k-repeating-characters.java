/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */
class Solution {
    int max = 0;
    public int longestSubstring(String s, int k) {
        //String
        //recursion
        if(s == null || s.length() < k){
            return 0;
        }
        int[] map = new int[26];
        for(char c:s.toCharArray()){
            map[c-'a']++;
        }
        char flag = '1';
        for(int i = 0;i < map.length;i++){
           if(map[i] != 0 && map[i] < k){
               flag = (char)(i+'a');
           }   
        }
        if(flag == '1'){
            return s.length();
        }
        String[] strs = s.split(String.valueOf(flag));
        int max = 0;
        for(String str:strs){
            max = Math.max(max,longestSubstring(str,k));
        }
        return max;
    }
}

