/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
       /* if(nums.length == 0) return 0;
        //sliding window
        int left = 0,right = 0,min = nums.length+1;
        int sum = nums[0];
        //o(n)
        while(right < nums.length){
            if(sum >= s ) {
                min = Math.min(min,right-left+1);
                sum -= nums[left];
                left++;
            }
            if(sum < s){        
                right++;
                if(right < nums.length)
                {
                    sum += nums[right];//right会溢出需要加条件
                }   
            }
        }
        return min == nums.length+1?0:min;*/
        //o(nlgn)
        //二分搜索
        //由于都是正数所以sum一定是增序
        int[] sum = new int[nums.length+1];
        int min = nums.length+1;
        for(int i = 0;i < nums.length;i++){
            sum[i] += i==0?nums[i]:nums[i]+sum[i-1];
        }
        for(int i = 1;i<sum.length;i++){
            int left = i,right = sum.length;
            while(left < right){
                int mid = left+(right-left)/2;
                if(sum[mid]-sum[i-1] < s){
                    left = mid+1;
                }
                else{
                    right = mid;
                }
            }
            min = Math.min(left-i+1,min);
        }
        return min == nums.length+1?0:min;
    }
}

