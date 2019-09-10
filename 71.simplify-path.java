import java.util.Deque;

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
       Deque<String> queue = new LinkedList<>();
       for(String S:s){
           if(S.equals("")||S.equals(".")){
                   continue;
           }
           if(S.equals("..")){
                if(!queue.isEmpty())queue.removeLast();
                else{
                    continue;
                }
            }
           else{
                queue.add(S);
           }
       }
       StringBuilder sb = new StringBuilder();
       while(!queue.isEmpty()){

           sb.append("/");
           sb.append(queue.poll());
           
       }

       return sb.length() == 0 ? "/":sb.toString();//corner case ""output "/"
    }
}

