import java.util.List;

/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {

        //array
        List<Integer> res = new ArrayList<>();
        //moore vote
        //思想是进行两次遍历
        //最多出现两个元素
        //第一次遍历是找到出现次数最多的两次
        int a = 0, b= 0,count1 = 0,count2 = 0;
        for(int n:nums){
            if(a == n) count1++;
            else if(b == n) count2++;
            else if(count1 == 0){a = n;count1 = 1;}
            else if(count2 == 0){b = n;count2 = 1;}
            else{ count1--;count2--;}
        }
        //第二次遍历是找到两个元素出现的次数
        count1 = 0;count2 = 0;
        for(int n:nums){
            if(n == a) count1++;
            else if(n == b) count2++;
        }
        if(count1 > nums.length/3) res.add(a);
        if(count2 > nums.length/3) res.add(b);

        return res;
    }
}

