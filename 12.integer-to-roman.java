/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */
class Solution {
    public String intToRoman(int num) {

        int[] map ={1000,900,500,400,100,90,50,40,10,9,5,4,1};

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i < map.length;i++){
            int count = 0;
            count = num/map[i];
            num = num%map[i];
            while(count > 0){
                sb.append(construct(map[i]));
                count--;
            }
            
        }

        return sb.toString();

        
    }
    private String construct(int num){

        //创建字典，把9和4的情况列出来
        if(num == 1) return "I";
        if(num == 4) return "IV";
        if(num == 5) return "V";
        if(num == 9) return "IX";
        if(num == 10) return "X";
        if(num == 40) return "XL";
        if(num == 50) return "L";
        if(num == 90) return "XC";
        if(num == 100) return "C";
        if(num == 400) return "CD";
        if(num == 500) return "D";
        if(num == 900) return "CM";
        if(num == 1000) return "M";
        return "";

    }
}

