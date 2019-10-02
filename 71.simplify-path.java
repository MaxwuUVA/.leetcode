/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */
class Solution {
    public String simplifyPath(String path) {

       // ..push
       // .keep
       // stack.peek() = '/' next'/'dont push
       // last '/' remove
       String[] s = path.split("/");
       StringBuilder sb = new StringBuilder("/");
       for(String S:s){
           if(S.equals("")||S.equals(".")){
               continue;
           }
           else if(S.equals("..")){
                if(sb.charAt(sb.length()-1) != '/')
                {
                       sb.deleteCharAt(sb.length()-1);
                }
                else{
                       sb.delete(sb.length()-2, sb.length()-1);
                }

           }
           else{
               sb.append(S);
               sb.append('/');
           }
       }
       sb.deleteCharAt(sb.length()-1);
       return sb.toString();
    }
}

