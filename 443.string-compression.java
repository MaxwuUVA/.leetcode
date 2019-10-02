/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */
class Solution {
    public int compress(char[] chars) {
        
        //string
        //sliding window
        int left = 0,right = 0,pos = 0;
        while(left < chars.length){
           if(right < chars.length && chars[left] == chars[right]){
               right++;
           }
           else{
               int len = right - left;
               if(len != 1){
                  String tmp = String.valueOf(len);
                  int strpos = 0;
                  chars[pos++] = chars[left];
                  while(strpos < tmp.length()){
                    chars[pos++] = tmp.charAt(strpos);
                    strpos++;
                 }
               }
               else{
                   chars[pos++] = chars[left];
               }
               left = right;
           }
            
        }
        return pos;
    }
}

