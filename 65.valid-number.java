/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 */
class Solution {
    public boolean isNumber(String s) {
        
        //string
        //字符串处理
        s = s.trim();
        //首字母为+-号可以
        //首字母为数字可以
        //小数点前后可以为空和数字
        //指数前可以为小数，后必须为整数
        char[] sc = s.toCharArray();
        int pos = 0;
        int pointcount = 0,dcount = 0;
        if(s == null || s.length() == 0){
            return false;
        }
        if(sc[pos] =='+' || sc[pos] =='-'){
                pos++;
        }
        while(pos < s.length()&&(Character.isDigit(sc[pos]) || sc[pos] == '.')){
            if(sc[pos] == '.'){
                pointcount++;
            }else if(Character.isDigit(sc[pos])){
                dcount++;
            }else{
                return false;
            }
            pos++;
        }
        if(dcount == 0 || pointcount > 1){
            return false;
        }
        if(pos == s.length()){
            return true;
        }
        if(sc[pos] != 'e'){
            return false;
        }
        dcount = 0;
        if(sc[pos] == 'e'){
           pos++;
           if(pos == s.length()){
               return false;
           }
           if(sc[pos] =='+' || sc[pos] =='-'){
                pos++;
           }
           while(pos < s.length()){
              if(!Character.isDigit(sc[pos])){
                  return false;
              }
              else{
                  dcount++;
              }
              pos++;
           }
        }
        return dcount > 0;
    }
}       
        


