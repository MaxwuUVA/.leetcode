/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */
class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        String[] str = new String[nums.length];
        int pos = 0;
        for(int n:nums){
            str[pos++] = String.valueOf(n);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String a,String b){
                //trick
                //比较string(a+b)和string(b+a);
                return (b+a).compareTo(a+b);
            }
        });
        if(str[0].equals("0")){
            return "0";//如果首位是0那么结果就是0
        }
        String res = String.join("",str);//string[]变成string
        return res;
    }
}

