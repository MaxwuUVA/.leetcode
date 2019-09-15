import java.util.ArrayList;


/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */
class Solution {
    private String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {

       
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()) return res;
        helper(digits,res,0,sb);
        return res;
        
    }
    private void helper(String s,List<String> res,int digit,StringBuilder sb){

        if(sb.length() == s.length()){
            res.add(sb.toString());
            return;
        }
        for(int i = 0;i < map[s.charAt(digit)-'0'- 2].length();i++){
            sb.append(map[s.charAt(digit)-'0'- 2].charAt(i));
            helper(s, res, digit+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

