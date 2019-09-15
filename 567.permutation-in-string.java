import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        //sliding window
        //由于都是小写，所以可以创建大小为26的字典
        //map1[]为字典s1,map2[]为字典s2
        //在s2上创建大小为s1.length的滑动窗口
        //假如map2与map1 match可以返回true
        //否则返回false

        if(s1.length() > s2.length()) return false;

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for(int i = 0;i<s1.length();i++){
            map1[s1.charAt(i)-'a']++;
            map2[s2.charAt(i)-'a']++;
        }
        for(int i = 0;i < s2.length()-s1.length();i++){
            if(ismatch(map1, map2)){
                return true;
            }
            map2[s2.charAt(i)-'a']--;
            map2[s2.charAt(i+s1.length())-'a']++;

        }

        return ismatch(map1, map2);
    }
    private boolean ismatch(int[] map1,int[] map2){

        for(int i = 0;i < 26;i++){
            if(map1[i] != map2[i]){

                return false;

            }
        }
        return true;

    }

}

