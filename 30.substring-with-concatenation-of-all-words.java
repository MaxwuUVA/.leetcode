import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        //思路就是用一个hashmap map1标柱words中单词出现的次数
        //然后对s的substring长度为所有单词加总的长度进行遍历，并存到map2中比较
        //如果出现不一样的单词，break
        //如果map2中出现的同样单词次数大于map1中的单词，也需要break
        //清空map2

        List<Integer> res = new ArrayList<>();
        if(s.isEmpty()|| words.length == 0) return res;
        Map<String,Integer> map1 = new HashMap<>();
        for(String word:words){

            map1.put(word,map1.getOrDefault(word, 0)+1);

        }
        for(int i = 0;i <= s.length()-words.length*words[0].length();i++){
            Map<String,Integer> map2 = new HashMap<>();
            for(int j = 0;j < words.length;j++){
                String cur = s.substring(i+j*words[0].length(),i+(j+1)*words[0].length());
                if(!map1.containsKey(cur)){
                    break;
                }
                map2.put(cur, map2.getOrDefault(cur,0)+1);
                if(map2.get(cur) > map1.get(cur)){
                    break;
                }
                if(j == words.length-1){
                    res.add(i);
                }
            }
            
        }

        return res;

    }
}

