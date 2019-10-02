/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 */
class Solution {
    public void wiggleSort(int[] nums) {
        //array
        Arrays.sort(nums);
        int left = (nums.length-1)/2,right = nums.length-1,pos = 0;
        int[] tmp = nums.clone();
        while(pos < nums.length && right >= (nums.length+1)/2){

            nums[pos++] = tmp[left];
            nums[pos++] = tmp[right];
            left--;
            right--;
        }
        if(pos < nums.length) nums[pos] = tmp[left];
    }
}

