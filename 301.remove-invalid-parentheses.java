/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        //string
        //bfs
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        ArrayList<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        boolean found = false;
        while(!queue.isEmpty()){
            String pk = queue.poll();
            if(isvalid(pk)){
                res.add(pk);
                set.add(pk);
                found = true;
            }
            if(found){
                   continue;
            }
            for(int i = 0; i < pk.length();i++){
              if(pk.charAt(i) == '(' ||
                 pk.charAt(i) == ')'){
                  
                    String left = pk.substring(0,i);
                  
                    String right = pk.substring(i+1);
                  
                    String tmp = left+right;
                  
                    if(!set.contains(tmp)){
                            queue.add(tmp);
                            set.add(tmp);
                        
                        }
                    }
            }   
        }
        
        return res;
        
    }
    private boolean isvalid(String s){   
        int open = 0, close = 0;
        for(char c:s.toCharArray()){
            if(c == '('){
                open++;
            }
            if(c == ')'){
                close++;
            }
            if(close > open){
                return false;
            }
        }
        return open == close;
    }
}

