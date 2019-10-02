/*
 * @lc app=leetcode id=330 lang=java
 *
 * [330] Patching Array
 */
class Solution {
    public int minPatches(int[] nums, int n) {
        
        //array
        //greedy
        //find the smallest missing number
        //eg[1,3] the smallest is 2
        //因为前面元素的和范围是[1,2)
        //对这个数组补2
        int res = 0,i = 0,l = nums.length;
        long miss = 1;
        while(miss <= n){
            if( i < l && miss >= nums[i]){
                //miss > nums[i],不需要补任何数字
                //更新miss,范围变成[1,miss+nums[i])
                miss += nums[i++];
            }
            else{
                //nums[i] 大于 miss，我们补miss并更新miss为miss+miss
                //范围变成[1,miss+miss)
                miss+=miss;
                res++;
            }
        }
        return res;
    }
}

