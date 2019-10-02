import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            
            List<List<String>> res = new ArrayList<>();
            Map<String,List> map = new HashMap<>(); 
            for(int i = 0; i < strs.length;i++){
                
                List<String> sub = new ArrayList<>();
                sub.add(strs[i]);
                char[] s = strs[i].toCharArray();
                Arrays.sort(s);
                String key = String.valueOf(s);
                if(!map.containsKey(key)) map.put(key,sub);
                else  map.get(key).add(strs[i]);
                
            }
            for(List sub:map.values()) res.add(sub);
            return res;
            
        }
}

