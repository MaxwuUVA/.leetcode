import com.sun.org.apache.regexp.internal.recompile;

/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */
class Solution {

    public String longestPalindrome(String s) {

        //直接递归O(2*n)
        //记忆化搜索
        //动态规划
        if(s.length() <= 1) return s;

        boolean[][] memo = new boolean[s.length()+1][s.length()+1];

        int Max = 0,start = 0,end = 0;

        for(int i = 0;i < s.length();i++)
           {
               memo[i][i] = true;

               for(int j = 0 ; j < i;j++){

                  if( i - j == 1) {

                       memo[j][i] = (s.charAt(i) == s.charAt(j));
                } else{

                       memo[j][i] = (s.charAt(i) == s.charAt(j)) && memo[j+1][i-1];

                   }
                   if(memo[j][i] == true) {

                        if(Max < i-j+1){

                           start = j;
                           end = i;
                           Max = i-j+1;

                }
             }
           }
        }
    
        return s.substring(start, end+1);
        
    }
    
}

