/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null||s.length() == 0) return "";
        //string
        //greedy+recurse
        String res = "";
        Integer[] map =new Integer[26];
        for(char c:s.toCharArray()){
            if(map[c-'a'] == null){
                map[c-'a'] = 1;
            }
            else map[c-'a']++;
        }
        int pos = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) < s.charAt(pos)){
                pos = i;
            }
            if(map[s.charAt(i)-'a'] != null){
                map[s.charAt(i)-'a']--;
                if(map[s.charAt(i)-'a'] == 0){
                    String cur = Character.toString(s.charAt(pos));
                    String tail = removeDuplicateLetters(s.substring(pos+1).replaceAll(cur,""));
                    res = cur+tail;
                    break;
                }
            }
            
        }
        
        return res;
        
    }
}

