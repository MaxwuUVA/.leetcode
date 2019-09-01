/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */
class Solution {
    public List<String> generateParenthesis(int n) {

        //求全局所有解显然需要用递归
        //观察括号的性质，如果在结束之前右括号数量大于左括号，则为非法
        int left = 0, right = 0;
        String cur = "";
        List<String> res = new ArrayList<>();
        helper(left,right,n,res,cur);

        return res;
        
    }
    private void helper(int left,int right,int n,List<String> res,String cur){
        if(left < right || left > n || right > n) return;
        if(left == n && right == n){
            res.add(cur);
            return;
        }
        helper(left+1, right, n, res, cur+"(");
        helper(left, right+1, n, res, cur+")");

    }
   
}

