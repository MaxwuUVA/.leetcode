/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */
class Solution {
    public String convert(String s, int numRows) {

        if(numRows <= 1) return s;
        StringBuilder sb = new StringBuilder();
        /*0       6       C
          1   5   7   B   D
          2 4     8 A     E
          3       9       F*/
        //第一行之间的距离差为2*numRows-2；
        //推得所有非之列之间的距离差均为2*numRows-2；
        //除第一行外所有行都有之字形元素 为下一之型首个元素减去列数
        //如5 = 2*4 - 2 - i = 5  B = 2*（2*4）- 2 - i = 11
        for(int i = 0;i < numRows;i++){
            for(int j = 0;j < s.length();j++){
                if( j % (2*numRows - 2) == i ) 
                {
                    sb.append(s.charAt(j));
                }
                if( i != 0  && i != numRows-1){
                    if(j%(2*numRows - 2) == 2*numRows - 2 - i)
                       sb.append(s.charAt(j));
                }
            }
        } 

        return sb.toString();
        
    }
}

