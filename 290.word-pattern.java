import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
         if(pattern == null || pattern.length() == 0){
             return str.length() == 0;
         }
         String[] s = str.split(" ");
         String[] map = new String[26];
         if(s.length != pattern.length()){
             return false;
         }
         for(int i = 0;i < s.length;i++){
             if(map[pattern.charAt(i)-'a'] == null){
                map[pattern.charAt(i)-'a'] = s[i];
             }
             else{
                 if(!s[i].equals(map[pattern.charAt(i)-'a'])){
                     return false;
                 }
             }
         }
        Set<String> set = new HashSet<>();
        for(String m:map){
             if(m != null){
                 if(set.contains(m)){
                     return false;
                 }
                 set.add(m);
             }
         }
        return true;
    }
}

