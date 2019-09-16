import java.util.Set;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */
class Solution {
    
    //记忆化搜索
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dic = new HashSet<>();
        dic.addAll(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        //Boolean[] memo = new Boolean[s.length()+1];
        /*return partition(dic,s,0,memo);    
    }
    private boolean partition(Set<String> dic,String s,int start,Boolean[] memo){
        if(start >= s.length()) return true;
        for(int i = start+1;i <= s.length();i++){
            if(memo[i] == null){
                memo[i] = partition(dic,s,i,memo);
            }
            if(dic.contains(s.substring(start,i)) && memo[i] == true){           
                return true;           
            }
        }
        return false;*/
    //dp
    //状态转移方程为dp[i] = dp[j](0<j<i)&&contains(substring(j,i))
       dp[0] = true;//sub(0)空string为真
       for(int i = 1;i <= s.length();i++){
           for(int j = 0;j < i;j++){
               if(dp[j] && dic.contains(s.substring(j, i))){
                   dp[i] = true;
                   break;
               }
           }

       }
       return dp[s.length()];
    }
}
