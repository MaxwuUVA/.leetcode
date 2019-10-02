/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */
class Solution {
    public int firstUniqChar(String s) {
        //string
        //map
        //two pass
        if(s.length() == 0) return -1;
        int[] map = new int[26];
        for(char c:s.toCharArray()){
            map[c-'a']++;
        }
        for(int i = 0;i < s.length();i++){
            if(map[s.charAt(i)-'a'] == 1){
                  return i;
            }
        }
        return -1;
        
    }
}

