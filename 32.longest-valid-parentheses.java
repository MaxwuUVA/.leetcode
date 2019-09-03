/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */
class Solution {
    public int longestValidParentheses(String s) {

        //int len = s.length();
        //if(s.length() == 1) return 0;
        //if(isValid(s)) return len;
        //记忆化搜索
       /* Integer[][] memo = new Integer[s.length()+1][s.length()+1];
        int start = 0,end = s.length();
        int res = helper(s, memo, start, end);
        return res;*/
        //参考leetcode答案
        int len = s.length();
        if(s.length() == 0) return 0;
        int[] dp = new int[len];
        int result = 0;
        int left = 0;
        for(int i = 0;i < len;i++){
            if(s.charAt(i) == '('){
                //dp[i] = 0;
                left++;
            }else if(left > 0){
                dp[i] += dp[i-1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i-dp[i]]:0;
                result = Math.max(result, dp[i]);
                left--;
            }
        }
        return result;
    }
    /*private Integer helper(String s,Integer[][] memo,int start,int end){
        if(start == end - 1) return 0;
        String target = s.substring(start,end);
        if(target.length() == 2){
            if(target.charAt(0) == '(' && target.charAt(1) == ')'){
                return 2;
            }
            else{
                return 0;
            }  
        }
        if(memo[start][end-1] == null){
           memo[start][end-1] = helper(s, memo, start, end-1);
         }
        if(memo[start+1][end] == null){
           memo[start+1][end] = helper(s, memo, start+1, end);
        }
        if(target.length()%2 == 0){
            if(memo[start][end-2] == end-start-2 && target.charAt(target.length()-2) == '('  && target.charAt(target.length()-1) == ')'){
                return target.length();
            }
            if(memo[start+1][end-1] == end-start-2 && target.charAt(0) == '('  && target.charAt(target.length()-1) == ')'){
                return target.length();
            }
        }
        return memo[start][end-1] > memo[start+1][end] ? memo[start][end-1]:memo[start+1][end];
    }*/
}

