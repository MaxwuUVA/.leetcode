import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */
class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
            if(map.get(nums[i]) > nums.length/2){
                return nums[i];
            }
            
        }
        return 1;
    }
}

