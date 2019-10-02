/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */
class Solution {
    public void reverseString(char[] s) {
         //string
         int left = 0, right = s.length-1;
         while(left < right){
             char tmp = s[left];
             s[left] = s[right];
             s[right] = tmp;
             left++;
             right--;
         }
    }
}

