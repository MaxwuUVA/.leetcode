/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        //array duplicate系列
        //two pointer
        //如果i > i-1 i,j一起出发，如果i == i-1 i前进，j不动，等待下一个赋值
        //O(n)级别
        int j = 0;
        for(int i = 0;i < nums.length;i++){
            if( i < 1 || nums[i] > nums[i-1]){
                nums[j] = nums[i];
                j++;
            }
            else{

                continue;

            }
        }
        return j;
    }
}

