/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */
class Solution {
    public void nextPermutation(int[] nums) {

        if(nums.length == 0) return;

        //全排列
        //1234
        //1243
        //1324
        //1342
        //1423
        //1432
        //...
        //可以找到规律从尾部找到升序的前一个元素
        //并把从后找到前一个元素的下一位
        //swap
        //再对后面的元素进行排序
        int end  = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int target = 0;
        int swappointer = 0;
        for( target = end ; target > 0;target--){
            if(nums[target-1] < nums[target]){
                break;
            }
        }
        target--;
        int pointer = target+1;
        if(target >= 0){
          while(pointer < nums.length){
             if(nums[pointer] > nums[target] && nums[pointer] - nums[target] < min){
                        swappointer = pointer;
                        min = nums[pointer] - nums[target];
                }
                pointer++;
          }
          int tmp = nums[swappointer];
          nums[swappointer] = nums[target];
          nums[target] = tmp;
        }
        Arrays.sort(nums,target+1,nums.length);
    }
}

