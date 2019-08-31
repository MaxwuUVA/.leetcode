/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */
class Solution {
    public String countAndSay(int n) {      
        return helper(n);     
    }
    private String helper(int n){    
        if(n == 1) return "1";  

        String cur = helper(n-1);  //求上一行的string

        char[] current = cur.toCharArray();
        
        char tmp = current[0];
        
        int count = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(char c:current){
            
            if(c != tmp){
                
                sb.append(count);//不等时将count和char插入
                sb.append(tmp);
                tmp = c;//更新char
                count = 1;//更新count
                
            }
            else{
                count++;
            }
        }
        sb.append(count);//由于标记时不等时，所以最后一个在循环内会被忘记
        sb.append(tmp); //在循环结束后插入
        return sb.toString();//返回
    }
}
//时间复杂度
//空间复杂的O(n)
