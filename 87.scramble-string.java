/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 */
class Solution {
    public boolean isScramble(String s1, String s2) {
        
        //String
        //recursion
        if(s1.length() != s2.length()) {
            return false;
        }
        if(s1.equals(s2)) {
            return true;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        
        Arrays.sort(str1);
        Arrays.sort(str2);
        String st1 = String.valueOf(str1);
        String st2 = String.valueOf(str2);
        if(!st1.equals(st2)){ 
                  return false;
        }
        for(int i = 1;i < s1.length();i++){
            String s11 = s1.substring(0,i);
            String s21 = s2.substring(0,i);
            String s12 = s1.substring(i);
            String s22 = s2.substring(i);
            if(isScramble(s11,s21) && isScramble(s12,s22)){
                 return true;
            }
            s21 = s2.substring(s2.length()-i);
            s22 = s2.substring(0,s2.length()-i); 
            if(isScramble(s11,s21) && isScramble(s12,s22)){
                 return true;
            }
        }
        return false;
    }
}

