import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Set<List<Integer>> map = new HashSet<>();

        Arrays.sort(nums);

        //双指针find
        for(int roof = nums.length -1 ;roof > 1;roof--){
            int left = 0,right = roof-1;

            while(left < right){

                if(nums[left]+nums[right]+nums[roof] == 0){

                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(nums[roof]);
                    if(!map.contains(list))
                    {
                        res.add(list);
                        map.add(list);
                    }
                    right--;
                }
                if(nums[left]+nums[right]+nums[roof] > 0){
                    right--;
                }
                else{
                    left++;
                }
            }

        }

        return res;
    }
}

