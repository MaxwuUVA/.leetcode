import javax.swing.text.AbstractDocument.LeafElement;

/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */
class Solution {
    private int t;
    public int search(int[] nums, int target) {

        //O(lgN)binary search
        int start = 0, end = nums.length-1,t = 0;
        return binarysearch(nums, target, start, end);
    
      
    }
    private int binarysearch(int[] nums,int target,int start,int end){
        //[0,..k][k+1..nums.length-1];
        //判断mid mid > start 0,mid sort;
        //mid < start mid end sort;
        if(start > end) return -1;
        int mid = start + (end - start)/2;
        if(nums[mid] == target) return mid; 
        //先判断是否有序，再判断target是否在其中
        if(nums[mid] < nums[end]){
            if(target > nums[mid] && target <= nums[end]) return binarysearch(nums, target, mid+1, end);
            else return binarysearch(nums, target, start, mid-1);
        }
        else{
            if(target < nums[mid] && target > nums[end]) return binarysearch(nums, target, start, mid-1);
            else return binarysearch(nums, target, mid+1, end);
        }
        
    }
}

