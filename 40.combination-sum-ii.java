import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //重写
        //时间复杂度
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list  = new ArrayList<>();
        Set<List<Integer>> visited = new HashSet<>();
        int start = 0,sum = 0;
        Arrays.sort(candidates);

        helper(res, list, candidates, target, start, visited, sum);

        return res;

        
    }
    private void helper(List<List<Integer>> res,List<Integer> list,int[] nums,int t,int start,Set<List<Integer>> set,int sum){
        if(sum == t && !set.contains(list)) {
            res.add(new ArrayList<>(list));
            set.add(new ArrayList<>(list));
        }
        if(sum > t) return;

        for(int i = start;i<nums.length;i++){
            sum += nums[i];
            list.add(nums[i]);
            helper(res, list, nums, t, i+1 ,set, sum);
            sum -= nums[i];
            list.remove(list.size()-1);

        }


    }
}

