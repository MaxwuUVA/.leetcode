/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */
class Solution {
    public int hIndex(int[] citations) {
        //bs
        //target
        //二分搜索
        //[0...n)左闭右开
        //可以类比求lowerbound
        //左指针逼近start = mid+1；
        //右指针排除end = mid
        if(citations.length == 0) return 0;
        int start = 0, end = citations.length;
        while(start < end){
            int mid = start + (end-start)/2;
            if(citations[mid] == citations.length-mid){
                return citations.length-mid;
            }
            if(citations[mid] > citations.length-mid){
                end = mid;
            }
            else if(citations[mid] < citations.length-mid){
                start = mid+1;
            }

        }

        return citations.length-start;
        
    }
}

