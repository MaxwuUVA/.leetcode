/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */
class Solution {
    public boolean canJump(int[] A) {
    //看当前所在的位置和能够到达的位置比较
    //reachable > current 就继续迭代当前位置
    //reachable < current 返回false


        int reachable = 0;
        for(int i=0;i<A.length;i++){
            if(i>reachable) {return false;}
            reachable = Math.max(A[i]+i,reachable);
        }
        return true;
    }
}

