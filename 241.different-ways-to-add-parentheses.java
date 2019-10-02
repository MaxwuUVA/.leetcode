/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        //String
        List<Integer> res = new ArrayList<>();
        if(input == null||
           input.length() == 0){
           return res;
        }
        for(int i = 0;i < input.length();i++){
            if(input.charAt(i) == '+'||
               input.charAt(i) == '-'||
               input.charAt(i) == '*'){
                String part1 = input.substring(0,i);
                String part2 = input.substring(i+1);
                List<Integer> left = diffWaysToCompute(part1);
                List<Integer> right = diffWaysToCompute(part2);
                for(Integer l:left){
                    for(Integer r:right){
                        int c = 0;
                        if(input.charAt(i) == '+') {
                            c = l+r;
                        }
                        if(input.charAt(i) == '-') {
                            c = l-r;
                        }
                        if(input.charAt(i) == '*') {
                            c = l*r;
                        }
                        res.add(c);
                    }
                    
                }
                
            }
            
        }
         if(res.size() == 0){
            res.add(Integer.valueOf(input));
            return res;
        }
        return res;
    }
}

