/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //string
        //hashmap
        int[] map = new int[26];
        for(char c:magazine.toCharArray()){
            map[c-'a']++;
        }
        for(char n:ransomNote.toCharArray()){
            map[n-'a']--;
            if(map[n-'a'] < 0){
                return false;
            }
        }
        return true;        
    }
}

