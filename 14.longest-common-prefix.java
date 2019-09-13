/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) return "";

        boolean find  = false;

        StringBuilder sb = new StringBuilder();
        //暴力法
        //以第一个string为model
        //遍历string array中所有的元素
        //从第0个元素开始，找是否所有元素在相同位置有相同的char
        //O(n*l) l为元素有几个char

        for(int i = 0;i < strs[0].length();i++){
            char cur = strs[0].charAt(i);
            for(int j = 1;j<strs.length;j++){
                 if( strs[j].length()-1 < i || strs[j].charAt(i) != cur){
                     find = true;
                     break;
                 }
            }
            if(find == true){
                break;
            }
            else{
                sb.append(cur);
            }
        }
        return sb.toString();
    }
}

