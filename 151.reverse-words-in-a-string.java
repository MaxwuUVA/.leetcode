/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */
class Solution {
    public String reverseWords(String s) {

        if(s == null || s.length() == 0) return "";
        //string
        //split
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length-1;i >= 0;i--){
                if(!strs[i].equals("")){
                    //corner case
                    //在string前插入“ ”
                    //防止后缀有“ ”
                    if (sb.length() > 0) {
                        sb.append(" ");
                    }
                    sb.append(strs[i]);
                }
        }
        return sb.toString();
    }
}

