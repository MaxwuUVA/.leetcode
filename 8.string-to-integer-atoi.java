/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */
class Solution {
    //这道题的test case 非常恶心
    //总之先判断空格的位置
    //再判断正负号
    //最后判断溢出
    
    public int myAtoi(String str) {

        if(str.length() == 0) return 0;

        int i = 0, sign=1, base=0;

        while(i < str.length() && str.charAt(i) == ' '){
            
            i++;

        }
        if( i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')){
            sign = str.charAt(i) == '-' ? -1:1;
            i++;
        }
        while(i<str.length()){
            
            if(((str.charAt(i)-'0') < 0 || (str.charAt(i)-'0') > 9)){
                
                break;
                
            }
            if( base > Integer.MAX_VALUE/10 || (base == Integer.MAX_VALUE/10 && (str.charAt(i)-'0') >7))        {
                return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            
            base = base*10+ (str.charAt(i)-'0');
            
            i++;
            
        }

        return sign*base;
        
    }
}

