import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        //yext
        //hashtable
        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            if(map1.containsKey(s.charAt(i))){
                 if(map1.get(s.charAt(i)) != t.charAt(i)) 
                      return false;
            }
            if(map2.containsKey(t.charAt(i))){
                if(map2.get(t.charAt(i))!= s.charAt(i)){
                      return false;
                }
            }
            map1.put(s.charAt(i),t.charAt(i));
            map2.put(t.charAt(i),s.charAt(i));
        }   
        return true;     
    }
}

