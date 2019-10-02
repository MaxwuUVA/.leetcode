/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        //binary search
        //int left = 0,right = nums.length-1,target = 0;
        // 1123344
        // 1122344
        // 112233455
        // 122334455
        /*while(left < right){
            int mid = left+(right-left)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                target = mid;
                break;
            }
            if((nums[mid] == nums[mid+1] && mid %2 == 1)||(nums[mid] == nums[mid-1]&& mid%2 == 0)){

                left = mid;

            }
            else{
                right = mid;
            }
        }

        return nums[target];*/
        int target = -1;
        for(int i = 1;i < nums.length-1;i+=2){
            if(nums[i] != nums[i-1]){
                target = i-1;
                break;
            }
        }
        return target == -1 ? nums[nums.length-1]:nums[target];
    }
    //更新bs
}

