import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */
class Solution {
    public int jump(int[] nums) {
        //bfs 遍历
        if(nums.length == 0) return 0;
        Deque<Integer> queue = new LinkedList<>();
        int count = 0;
        int top = 0;
        queue.add(top);
        boolean[] visited = new boolean[nums.length];
        while(!queue.isEmpty()){
            top = queue.poll();
            if(top+nums[top] >= nums.length-1){
                    return top == nums.length-1?count:count+1;
             } 
            int tmp = top+1+nums[top+1];
            queue.add(top+1);
            for(int i = top+1;i <= top + nums[top];i++){
                
                if(visited[i] == false && i+nums[i] > tmp){
                    queue.poll();
                    queue.add(i);
                    tmp = i+nums[i];
                    visited[i] = true;
                }

            }
            count++;
        }
        return count;
    }
}
