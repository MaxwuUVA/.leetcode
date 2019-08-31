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

