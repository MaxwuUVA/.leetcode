/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */
class Solution {
    public int findDuplicate(int[] nums) {
        //array
        //two pointer
        //由于重复数字的存在，则所有数字必定形成一个环[1,2,3,4,3] 0->1->2->3->4->3
        //3,4形成闭环，那么用快慢指针先遍历一边取到相同的数字跳出，指针在环内，
        //因为快指针每次走2，慢指针每次走1，快指针走的距离是慢指针的两倍。而快指针又比慢指针多走了一圈。
        //所以 head 到环的起点+环的起点到他们相遇的点的距离 与 环一圈的距离相等。
        //现在重新开始，head 运行到环起点 和 相遇点到环起点 的距离也是相等的，相当于他们同时减掉了 环的起点到他们相遇的点的距离
        int slow = 0,fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        int pointer = 0;
        while(true){
            slow = nums[slow];
            pointer = nums[pointer];
            if(slow == pointer) break;
        }
        
       return slow;
        
    }
}

