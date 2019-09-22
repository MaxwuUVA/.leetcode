

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        //backtracking
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> ele = new LinkedList<>();

        helper(candidates,target,res,ele,0,0);

        return res;

        
    }
    private void helper(int[] candidates, int target, List<List<Integer>> res,List<Integer> ele,int start,int sum){

        if(sum == target) res.add(new LinkedList<>(ele));//符合存入res
        if(sum > target) return;//不符合返回

        for(int i = start;i < candidates.length;i++){
            sum += candidates[i];
            ele.add(candidates[i]);
            helper(candidates, target, res, ele, i, sum);
            sum -= candidates[i];
            ele.remove(ele.size()-1);
        }
    }
}

