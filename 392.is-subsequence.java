/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) return true;
        if(t == null || t.length() == 0) return false;
        //String
        //two pointer
        int head = 0,track = 0;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(head == t.length()){
                return false;
            }
            for(int j = head; j < t.length();j++){
                if(t.charAt(j) == c){
                    head = j+1;
                    break;
                }
                if(j == t.length()-1){
                    return false;
                }
            }
        }
        return true;
    }
}
